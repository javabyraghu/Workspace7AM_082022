package com.app.raghu;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProcessTest {

	@BeforeAll
	public static void firstSetup() {
		System.out.println("ONLY ONCE AT BEGINNING");
	}

	@BeforeEach
	public void setup() {
		System.out.println("FROM BEFORE");
	}

	@Order(30)
	@Test
	@DisplayName("FROM A TEST")
	public void testA() {
		assertAll(
				()->assertEquals(10, 10),
				()->assertNotNull(this)
				);
	}

	@Test
	@Disabled
	public void testB() {
		System.out.println("FROM TEST#B METHOD");
	}

	@Order(20)
	@Test
	@DisplayName("FROM C TEST")
	public void testC() {
		System.out.println("FROM TEST#C METHOD");
	}

	@AfterEach
	public void clean() {
		System.out.println("FROM AFTER");
	}

	@AfterAll
	public static void lastCleanup() {
		System.out.println("ONLY ONCE AT END");
	}
}
