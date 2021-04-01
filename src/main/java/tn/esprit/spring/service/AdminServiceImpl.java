package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.AdminRepository;
import tn.esprit.spring.Repository.ProductRepository;
import tn.esprit.spring.config.AdminPrincipal;
import tn.esprit.spring.entity.Administrator;

@Service
@Qualifier("UserDetailsService")
public class AdminServiceImpl implements IAdminService {
	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ProductRepository productRepository;
	// @Autowired
	// RoleRepository RoleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Administrator saveUser(String Email_admin, String Name_admin, String username, String password,
			String confirmedPassword) {
		Administrator user = adminRepository.findByUsername(username);
		if (user != null)
			throw new RuntimeException("User already exists");
		if (!password.equals(confirmedPassword))
			throw new RuntimeException("Please confirm your password");
		Administrator User = new Administrator();
		User.setUsername(username);
		User.setEmail_admin(Email_admin);
		User.setName_admin(Name_admin);
		User.setActived(true);
		User.setPassword_admin(passwordEncoder.encode(password));
		adminRepository.save(User);
		// addRoleToUser(username, "USER");
		return User;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Administrator user = adminRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("invalid user");
		Collection<GrantedAuthority> authorities = new ArrayList<>();

		return new AdminPrincipal(user);
	}

	@Override
	public Administrator findUserByUserName(String userName) {

		return adminRepository.findByUsername(userName);

	}

	@Override
	public List<String> findClientbyUsername(String userName) {

		return adminRepository.findClientbyUsername(userName);

	}

	public void Block(String userName) {

		adminRepository.Block(userName);
	}

	@Override
	public List<String> ProductOutOfStock() {

		return adminRepository.ProductOutOfStock();

	}

}
