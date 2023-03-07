package com.app.raghu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	List<Movie> findByGener(String gener);
}

