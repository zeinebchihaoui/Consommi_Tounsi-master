package tn.esprit.spring.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import tn.esprit.spring.entity.Administrator;

public interface IAdminService extends UserDetailsService {
	public UserDetails loadUserByUsername(String username);

	public Administrator findUserByUserName(String userName);

	public Administrator saveUser(String Email_admin, String Name_admin, String username, String password,
			String confirmedPassword);

	List<String> findClientbyUsername(String userName);

	List<String> ProductOutOfStock();
}
