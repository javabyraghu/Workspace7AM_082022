package com.app.raghu.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.raghu.util.JwtUtil;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// read Token from Request Header
		String token = request.getHeader("Authorization");
		if (token != null) {

			// validate and read subject from token
			String username = jwtUtil.getUsername(token);

			// check userdetails
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				// load user from DB
				UserDetails user = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authenitcation = new UsernamePasswordAuthenticationToken(username,
						user.getPassword(), user.getAuthorities());
				authenitcation.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenitcation);
			}
		}

		filterChain.doFilter(request, response);
	}

}
