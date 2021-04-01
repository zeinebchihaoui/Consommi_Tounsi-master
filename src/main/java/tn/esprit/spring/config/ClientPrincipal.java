package tn.esprit.spring.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tn.esprit.spring.entity.Client;

public class ClientPrincipal implements UserDetails {

	/**
	 * 
	 */
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	private static final long serialVersionUID = 1L;

	private Client user;

	public ClientPrincipal(Client user) {
		super();
		this.user = user;
	}

	public ClientPrincipal(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities = new ArrayList<>();

		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword_client();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.isActived();
	}

}
