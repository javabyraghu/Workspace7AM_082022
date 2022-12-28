package com.app.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
