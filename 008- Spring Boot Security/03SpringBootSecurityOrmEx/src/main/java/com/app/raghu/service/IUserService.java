package com.app.raghu.service;

import java.util.Optional;

import com.app.raghu.entity.User;

public interface IUserService {

	Integer saveUser(User user);
	Optional<User> getOneUser(Integer id);
}
