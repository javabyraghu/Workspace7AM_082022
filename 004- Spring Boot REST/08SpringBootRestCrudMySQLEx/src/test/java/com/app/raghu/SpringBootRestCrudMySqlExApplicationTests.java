package com.app.raghu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application.properties")
public class SpringBootRestCrudMySqlExApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	/**
	 * Test save Operation
	 */
	@Test
	// @Disabled -- Skip the test method
	@DisplayName("TESTING STUDENT SAVE OPERATIONS")
	@Order(1)
	public void testCreateStudent() throws Exception {
		// 1. CREATE MOCKED REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post("http://localhost:9690/v1/api/student/create").contentType(MediaType.APPLICATION_JSON)
				.content("{\"stdName\":\"AJAY\",\"stdGen\":\"Male\",\"stdCourse\":\"JAVA\",\"stdAddr\":\"HYD IND\"}");

		// 2. EXECUTE IT AND READ RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();

		// 4. ASSERT RESULT USING JUNIT
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		if (!response.getContentAsString().contains("CREATED")) {
			fail("STUDENT NOT CREATED!!");
		}

	}

	// This is short format
	/*
	 * @Test
	 * 
	 * @DisplayName("TESTING STUDENT SAVE OPERATIONS IN SHORT")
	 * 
	 * @Order(1) public void testCreateStudentShort() throws Exception {
	 * 
	 * mockMvc.perform( post("http://localhost:9690/v1/api/student/create")
	 * .contentType(MediaType.APPLICATION_JSON)
	 * .content("{\"stdName\":\"AJAY\",\"stdGen\":\"Male\",\"stdCourse\":\"JAVA\",\"stdAddr\":\"HYD IND\"}"
	 * )) .andExpect( status().isCreated() );
	 * 
	 * 
	 * }
	 */

	@Test
	@Order(2)
	@DisplayName("GET ALL STUDENTS")
	public void testGetAllStudents() throws Exception {
		// 1. create request
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("http://localhost:9690/v1/api/student/all");

		// 2. execute it
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. read response
		MockHttpServletResponse response = result.getResponse();

		// 4. assert result
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());

	}

	@Test
	@Order(3)
	@DisplayName("GET ONE STUDENT BY ID")
	public void testGetOneStudent() throws Exception {
		// 1. create request
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
				"http://localhost:9690/v1/api/student/find/{id}",1);

		// 2. execute it
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. read response
		MockHttpServletResponse response = result.getResponse();

		// 4. assert result
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
	}

	@Test
	@DisplayName("TESTING STUDENT UPDATE OPERATIONS")
	@Order(4)
	public void testupdateStudent() throws Exception {
		// 1. CREATE MOCKED REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.put("http://localhost:9690/v1/api/student/modify")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"stdId\":1,\"stdName\":\"AA\",\"stdGen\":\"Male\",\"stdCourse\":\"JAVA\",\"stdAddr\":\"HYD IND\"}");

		// 2. EXECUTE IT AND READ RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();

		// 4. ASSERT RESULT USING JUNIT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		if (!response.getContentAsString().contains("UPDATED")) {
			fail("STUDENT NOT UPDATED!!");
		}

	}
	
	
	@Test
	@Order(5)
	@DisplayName("TEST DELETE STUDENT BY ID")
	public void testDeleteStudent() throws Exception {
		// 1. create request
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(
				"http://localhost:9690/v1/api/student/remove/{id}",1);

		// 2. execute it
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. read response
		MockHttpServletResponse response = result.getResponse();

		// 4. assert result
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
	}
}
