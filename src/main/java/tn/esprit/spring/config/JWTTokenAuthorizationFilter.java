package tn.esprit.spring.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import tn.esprit.spring.service.IClientService;

//import tn.esprit.spring.Service.IAdminService;

@Component
public class JWTTokenAuthorizationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private IClientService userService;

	// @Autowired
	// IAdminService adminService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
			response.setStatus(HttpStatus.OK.value());
		} else {

			String requestToken = request.getHeader("Authorization");

			String userName = null;
			String jwtToken = null;

			if (requestToken != null && requestToken.startsWith("Bearer ")) {
				jwtToken = requestToken.substring(7);
				userName = this.jwtTokenUtil.getUserNameFromToken(jwtToken);

			} else {
				logger.warn(
						"JWT token is null or does not begin with Bearer String for url " + request.getRequestURI());
			}

			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UserDetails userDetails = this.userService.loadUserByUsername(userName);

				if (userDetails != null && this.jwtTokenUtil.validatToken(jwtToken, userDetails.getUsername())) {

					List<GrantedAuthority> authorities = this.jwtTokenUtil.getAuthoritiesClaimFromToken(jwtToken);

					Authentication authentication = this.jwtTokenUtil.getAthentication(userName, authorities, request);

					SecurityContextHolder.getContext().setAuthentication(authentication);

				} else {
					SecurityContextHolder.clearContext();
				}
			}

		}
		filterChain.doFilter(request, response);

	}

}