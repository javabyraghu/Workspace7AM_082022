package com.app.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
