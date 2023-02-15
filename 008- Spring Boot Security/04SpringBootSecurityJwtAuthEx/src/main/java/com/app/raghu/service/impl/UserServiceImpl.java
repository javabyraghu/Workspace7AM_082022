package com.app.raghu.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.raghu.entity.User;
import com.app.raghu.repo.UserRepository;
import com.app.raghu.service.IUserService;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Integer saveUser(User user) {
		String pwd = encoder.encode(user.getPassword());
		user.setPassword(pwd);
		return repo.save(user).getId();
	}

	public User findByUsername(String username) {
		Optional<User> opt = repo.findByUsername(username);
		if(opt.isPresent())
			return opt.get();
		return null;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = findByUsername(username);
		if(null == user)
			throw new UsernameNotFoundException(username + " not exist");
		
		List<GrantedAuthority> list = 
				user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role))
					.collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(
				username, user.getPassword(), list);
	}

}
