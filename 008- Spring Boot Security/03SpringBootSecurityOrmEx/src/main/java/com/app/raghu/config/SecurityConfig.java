package com.app.raghu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	//old
	/*
	void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}*/

	//new code--starts
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration authConfig) 
					throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	//new code ends
	
	@Bean
	public SecurityFilterChain configureAuth(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				request->request.antMatchers("/home","/","/user/**").permitAll()
						.antMatchers("/admin").hasAuthority("ADMIN")
						//.antMatchers("/**").hasAuthority("ADMIN") //ADMIN CAN ACCESS EVERY URL
						.antMatchers("/customer").hasAuthority("CUSTOMER")
						.anyRequest().authenticated()
				)
		.formLogin(
				form->form.loginPage("/login").permitAll()
				.defaultSuccessUrl("/hello", true)
				)
		.logout(logout->logout.permitAll())	;
		
		
		return http.build();
	}
	


}
