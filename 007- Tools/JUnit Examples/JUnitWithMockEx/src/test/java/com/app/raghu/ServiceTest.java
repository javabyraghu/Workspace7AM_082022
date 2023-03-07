package com.app.raghu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	@Mock //creates stub for Repository (Dummy Impl code)
	private Repository repo;
	
	@InjectMocks //creates actual object of service with dummy Repo object injected
	private Service sob;
	
	@Test
	public void testGetDataLen() throws SQLException {
		//provide dummy impl for method getData(), that returns Array of 5 elements
		when(repo.getData())
		.thenReturn(Arrays.asList("A","B","TEST","WELCOME","FORMAT"));
		
		List<String> list = sob.getDataLen();
		assertNotNull(list);
		assertEquals(list.size(), 3);
		
	}
	
	@Test
	public void testGetDataException() throws SQLException {
		when(repo.getData())
		.thenThrow(new SQLException("Problem Exist"));
		
		List<String> list = sob.getDataLen();
		assertNotNull(list);
		assertEquals(list.size(), 0);
	}
	
	
	
}
