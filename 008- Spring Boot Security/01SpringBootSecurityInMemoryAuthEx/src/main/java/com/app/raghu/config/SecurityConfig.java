package com.app.raghu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// 2. Authorization
	@Bean
	public SecurityFilterChain configurePaths(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				request -> request.antMatchers("/","/home").permitAll()
				.anyRequest().authenticated()
				)
			.formLogin( form -> form.loginPage("/login").permitAll() )
			.logout( logout -> logout.permitAll() );
			
		return http.build();
	}
	
	//old style
	/*
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/home").permitAll()
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/hello")
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout");
	}
	*/
	
	

	// 1. Authentication (InMemory)
	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails user = User.withDefaultPasswordEncoder()
				.username("sam").password("sam").roles("ADMIN")
				.build();
		
		UserDetails user2 = User.withDefaultPasswordEncoder()
				.username("ram").password("ram").roles("CUSTOMER")
				.build();
		
		return new InMemoryUserDetailsManager(user,user2);
	}

}
