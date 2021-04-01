package tn.esprit.spring.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tn.esprit.spring.entity.Administrator;

public class AdminPrincipal implements UserDetails {

	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private static final long serialVersionUID = 1L;

	private Administrator admin;

	public AdminPrincipal(Administrator admin) {
		super();
		this.admin = admin;
	}

	public AdminPrincipal(String username, String password) {
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
		return this.admin.getPassword_admin();
	}

	@Override
	public String getUsername() {
		return this.admin.getUsername();
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
		return this.admin.isActived();
	}

}
