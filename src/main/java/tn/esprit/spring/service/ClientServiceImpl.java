package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.config.ClientPrincipal;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Delivery_Man;

@Service
@Qualifier("UserDetailsService")

public class ClientServiceImpl implements IClientService {

	@Autowired
	PasswordEncoder pwd;
	@Autowired
	ClientRepository userRepository;
	private JavaMailSender javaMailSender;
	// AdminRepository adminRepository;
	/*
	 * @Autowired RoleRepository RoleRepository;
	 */
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<Client> retrieveAllUsers() {
		return (List<Client>) userRepository.findAll();
	}

	@Override
	public Client addUser(Client u) {
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public Client updateUser(Client u) {
		userRepository.save(u);
		return u;
	}

	@Override
	public Client retrieveUser(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<Client> findAllUsers() {

		return (List<Client>) userRepository.findAll();
	}

	@Override
	public List<String> findClientOrder() {
		return userRepository.findClientOrder();

	}

	@Override
	public Client saveUser(String name_client, int pnum, String username, String password, String confirmedPassword,
			String email_client, String city_client, String address_client, int postal_code_client) {
		Client user = userRepository.findByUsername(username);
		if (user != null)
			throw new RuntimeException("User already exists");
		if (!password.equals(confirmedPassword))
			throw new RuntimeException("Please confirm your password");
		Client User = new Client();
		User.setUsername(username);
		User.setName_client(name_client);
		User.setPhone_num_client(pnum);
		User.setActived(true);
		User.setAdress_client(email_client);
		User.setCity_client(city_client);
		User.setEmail_client(email_client);
		User.setPostal_code_client(postal_code_client);

		User.setPassword_client(passwordEncoder.encode(password));
		userRepository.save(User);

		return User;
	}

	/*
	 * @Override public Role save(Role role) { return RoleRepository.save(role); }
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("invalid user");
		Collection<GrantedAuthority> authorities = new ArrayList<>();

		return new ClientPrincipal(user);
	}

	/*
	 * @Override public void addRoleToUser(String username, String rolename) { User
	 * User = userRepository.findByUsername(username); Role Role =
	 * RoleRepository.findByRoleName(rolename); User.getRoles().add(Role); }
	 */

	@Override
	public Client findUserByUserName(String userName) {

		return userRepository.findByUsername(userName);

	}
	
	}
	
	


