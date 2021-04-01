package tn.esprit.spring.Control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.AdminRepository;
import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.Repository.Delivery_ManRepository;
import tn.esprit.spring.config.AdminPrincipal;
import tn.esprit.spring.config.JWTTokenUtil;
import tn.esprit.spring.entity.Administrator;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Delivery_Man;
import tn.esprit.spring.entity.Stat;
import tn.esprit.spring.service.AdminServiceImpl;
import tn.esprit.spring.service.Delivery_ManService;
import tn.esprit.spring.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	ClientRepository clientRepository;

	@Autowired
	IAdminService adminService;

	@Autowired
	AdminServiceImpl adminServiceImpl;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JWTTokenUtil jwtTokenUtil;

	@Autowired
	Delivery_ManRepository DelivMRepository;
	@Autowired
	Delivery_ManService DelivService;

	@PostMapping("/register")
	public Administrator register(@RequestBody AdminForm userForm) {
		return adminService.saveUser(userForm.getEmail_admin(), userForm.getName_admin(), userForm.getUsername(),
				userForm.getPassword(), userForm.getConfirmedPassword());
	}

	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Administrator> login(@RequestBody AdminLogin userr) {

		this.authenticate(userr.getUsername(), userr.getPassword());

		Administrator admin = adminService.findUserByUserName(userr.getUsername());

		admin.setPassword_admin(null);
		System.out.println("conntected");
		String jwtToken = this.jwtTokenUtil.generateToken1(new AdminPrincipal(admin));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + jwtToken);

		return ResponseEntity.ok().headers(headers).body(admin);

	}

	private void authenticate(String userName, String password) {

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));

	}

	@GetMapping(value = "getClientByUsername/{username}")
	public List<String> findClientbyUsername(@PathVariable("username") String username) {
		return adminServiceImpl.findClientbyUsername(username);
	}

	@PutMapping(value = "updateAdmin}")
	public Administrator updateAdmin(@RequestBody Administrator a) {
		return adminRepository.save(a);
	}

	@PutMapping(value = "BlockClient/{id}")
	public void block(@PathVariable int id) {
		Client c = clientRepository.findById(id).get();
		c.setActived(false);
		clientRepository.save(c);
	}

	@PutMapping(value = "ActiveClient/{id}")
	public void Active(@PathVariable int id) {
		Client c = clientRepository.findById(id).get();
		c.setActived(true);
		clientRepository.save(c);
	}

	@GetMapping(value = "OutOfStock")
	public List<String> ProductOutOfStock() {
		return adminServiceImpl.ProductOutOfStock();
	}

	private List<Stat> top10;

	public List<Stat> getTop10() {
		return top10;
	}

	public void setTop10(List<Stat> top10) {
		this.top10 = top10;
	}

	@GetMapping(value = "Top10DM")

	public List<String> StatTop10liv() {
		top10 = new ArrayList<>();
		List<Long> Liste10Liv = new ArrayList<>();
		Liste10Liv = adminRepository.Top10nbLivreur();
		Delivery_Man DeliveryM = new Delivery_Man();

		List<String> a = new ArrayList<>();

		for (long i : Liste10Liv) {
			DeliveryM = DelivMRepository.findById((int) i).get();
			a.add(DeliveryM.getName_deliv_man());
			System.out.println(DeliveryM.getChargeT_liv());
			System.out.println(DeliveryM.getName_deliv_man());

		}

		return a;
	}

}

class AdminForm {
	private String username;
	private String password;
	private String confirmedPassword;

	private String name_admin;

	private boolean actived;

	private String email_admin;

	private String password_admin;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public String getName_admin() {
		return name_admin;
	}

	public void setName_admin(String name_admin) {
		this.name_admin = name_admin;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public String getEmail_admin() {
		return email_admin;
	}

	public void setEmail_admin(String email_admin) {
		this.email_admin = email_admin;
	}

	public String getPassword_admin() {
		return password_admin;
	}

	public void setPassword_admin(String password_admin) {
		this.password_admin = password_admin;
	}

}

class AdminLogin {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
// public Client getPassword(String email)throws MailException,
// MessagingException{
// Client c=clientrepository.getPassword(email);
// c.getEncrytedPassword();
// SimpleMailMessage mail = new SimpleMailMessage();
