package com.app.raghu.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	//findBy -->SELECT + where = !=, > < null, not null, and or...
	//SQL: select * from book where book_cost=? 
	List<Book> findByBookCostLessThanEqual(Double bookCost);

	//SQL: select * from book where book_id!=? 
	//List<Book> findByBookIdNot(Integer bookId);
	
	//SQL: select * from book where cost = ? 
	//List<Book> findByBookCostEqual(Double bookCost);

	//SQL: select * from book where cost >= ? 
	//List<Book> findByBookCostGreaterThan(Double bookCost);
	
	//SQL: select * from book where author is null 
	List<Book> findByAuthorIsNull();
	
	//SQL: select * from book where author is not null 
	//List<Book> findByAuthorIsNotNull();
	//List<Book> findByAuthorNotNull();
	
	//------------Like Operator---------------------
	//SQL: Select * from book where author like ?
	List<Book> findByAuthorLike(String expression);
	
	//SQL: Select * from book where author like ? order by bookname DESC
	List<Book> findByAuthorLikeOrderByBookNameDesc(String expression);

	//SQL: Select * from book where author not like ?
	//List<Book> findByAuthorNotLike(String expression);

	//SQL: Select * from book where author like 'input%'
	List<Book> findByAuthorStartingWith(String input);
	
	
	//SQL: Select * from book where author like '%input'
	List<Book> findByAuthorEndingWith(String input);
	
	//SQL: Select * from book where author like '%input%'
	List<Book> findByAuthorContaining(String input);
	
	//SQL: Select * from book where bid between x and y
	List<Book> findByBookIdBetween(Integer id1,Integer id2);
	
	//--------------AND / OR --------------------------
	//SQL: select * from book where bookId <= ? or bookType like ?
	List<Book> findByBookIdLessThanEqualOrBookTypeLike(Integer bookId, String input);
	
	//SQL: select * from book where bookcost != ? and author not like ?
	//TASK FOR YOU
	
	//-------------single row-----------------------------
	Optional<Book> findByBookIdIs(Integer id);
	
}
