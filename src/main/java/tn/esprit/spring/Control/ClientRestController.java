package tn.esprit.spring.Control;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.config.ClientPrincipal;
import tn.esprit.spring.config.JWTTokenUtil;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.ClientServiceImpl;
import tn.esprit.spring.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRestController {
	// private Logger logger= LoggerFactory.getLogger(ClientRestController.class);
	@Autowired
	IClientService userService;

	@Autowired
	ClientRepository clientrepository;
	@Autowired
	ClientServiceImpl clientServiceImpl;
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JWTTokenUtil jwtTokenUtil;

	@PostMapping("/register")
	public Client register(@RequestBody UserForm userForm) {
		return userService.saveUser(userForm.getName_client(), userForm.getPhone_num_client(), userForm.getUsername(),
				userForm.getPassword(), userForm.getConfirmedPassword(), userForm.getEmail_client(),
				userForm.getCity_client(), userForm.getAdress_client(), userForm.getPostal_code_client());
	}

	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Client> login(@RequestBody UserLogin userr) {

		this.authenticate(userr.getUsername(), userr.getPassword());

		Client user = userService.findUserByUserName(userr.getUsername());

		user.setPassword_client(null);
		System.out.println("conntected");
		String jwtToken = this.jwtTokenUtil.generateToken(new ClientPrincipal(user));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + jwtToken);

		return ResponseEntity.ok().headers(headers).body(user);

	}

	private void authenticate(String userName, String password) {

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));

	}

	/*
	 * @RequestMapping("/sendmail") public String sendmail(){ try{
	 * clientServiceImpl.sendmail(); }catch(MailException e){
	 * logger.info("errorrrrrrrrr"+e.getMessage()); } return "mail envoyé"; }
	 */
	@GetMapping(value = "GetClientOrder")
	public List<String> findClientOrder() {
		return clientServiceImpl.findClientOrder();
	}
	
	
}

class UserForm {
	private String username;
	private String password;
	private String confirmedPassword;
	private String name_client;
	private int phone_num_client;

	private String email_client;

	private boolean actived;

	private String city_client;

	private String adress_client;

	private int postal_code_client;

	public String getEmail_client() {
		return email_client;
	}

	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public String getCity_client() {
		return city_client;
	}

	public void setCity_client(String city_client) {
		this.city_client = city_client;
	}

	public String getAdress_client() {
		return adress_client;
	}

	public void setAdress_client(String adress_client) {
		this.adress_client = adress_client;
	}

	public int getPostal_code_client() {
		return postal_code_client;
	}

	public void setPostal_code_client(int postal_code_client) {
		this.postal_code_client = postal_code_client;
	}

	public String getUsername() {
		return username;
	}

	public String getName_client() {
		return name_client;
	}

	public void setName_client(String name_client) {
		this.name_client = name_client;
	}

	public int getPhone_num_client() {
		return phone_num_client;
	}

	public void setPhone_num_client(int phone_num_client) {
		this.phone_num_client = phone_num_client;
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

	
}

class UserLogin {
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

// @Transactional
// public void actif(long id){
// Client c=clientrepository.findById(id).get();
// c.setEnabled(true);
// clientrepository.save(c);

// *public void block(long id){
// Client c=clientrepository.findById(id).get();
// c.setEnabled(false);
// clientrepository.save(c);
// }
