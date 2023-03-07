package com.app.raghu.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.raghu.entity.Movie;
import com.app.raghu.repo.MovieRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieRepositoryTest {

	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	@Order(1)
	@DisplayName("TESTING SAVE OPERATION")
	public void testSave() {
		Movie rrr = new Movie();
		rrr.setName("RRR");
		rrr.setGener("Action");
		rrr.setReleaseDate(LocalDate.of(2022, Month.MARCH, 24));
		rrr = movieRepository.save(rrr);
		
		assertNotNull(rrr);
		assertNotNull(rrr.getId());
	}
	
	@Test
	@Order(2)
	@DisplayName("TESTING FETCH ALL OPERATION")
	public void testFindAll() {
		Movie rrr = new Movie();
		rrr.setName("RRR");
		rrr.setGener("Action");
		rrr.setReleaseDate(LocalDate.of(2022, Month.MARCH, 24));
		movieRepository.save(rrr);
		
		Movie kantara = new Movie();
		kantara.setName("KANTARA");
		kantara.setGener("Thriller");
		kantara.setReleaseDate(LocalDate.of(2022, Month.SEPTEMBER, 30));
		movieRepository.save(kantara);

		List<Movie> list = movieRepository.findAll();
		
		assertNotNull(list);
		assertThat(list).isNotNull();
		
		assertEquals(2, list.size());
	}
	
}
