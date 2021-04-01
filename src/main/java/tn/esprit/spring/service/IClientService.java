package tn.esprit.spring.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import tn.esprit.spring.entity.Client;

public interface IClientService extends UserDetailsService {

	public UserDetails loadUserByUsername(String username);

	public Client findUserByUserName(String userName);

	List<Client> retrieveAllUsers();

	Client addUser(Client u);

	void deleteUser(int id);

	Client updateUser(Client u);

	Client retrieveUser(int id);

	List<Client> findAllUsers();

	public Client saveUser(String name_client, int phone_num_client, String username, String password,
			String confirmedPassword, String email_client, String city_client, String adress_client,
			int postal_code_client);

	List<String> findClientOrder();

}
