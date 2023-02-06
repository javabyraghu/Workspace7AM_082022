package com.app.raghu.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//authorization
	@Bean
	public SecurityFilterChain configureAuth(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				request->request.antMatchers("/home","/").permitAll()
						.antMatchers("/admin").hasAuthority("ADMIN")
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
	
	//authentication
	@Bean
	public UserDetailsService userDetailsService(DataSource datasource) {
		UserDetails user1  = User.withUsername("sam")
				.password("$2a$10$TD7ldmKUQw3EHFxVivyA8OUrzy7butY9QDRnltnBS/b9aI0j6reYq")
				.authorities("ADMIN").build();
		
		UserDetails user2  = User.withUsername("ram")
				.password("$2a$10$dEm8gdOC0R2S7IgXSnBKFOSeeKbCNuVeMC/hP24eY7zdADlUif4n.")
				.authorities("CUSTOMER").build();
		
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(datasource);
		users.createUser(user1);
		users.createUser(user2);
		
		return users;
	}


}
