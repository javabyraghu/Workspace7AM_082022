package com.app.raghu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

	Calculator c;
	int a, b, actual, expected;

	@BeforeEach
	public void setup() {
		c = new Calculator();
		a = 10;
		b = 20;
		expected = 200;
	}

	@Test
	@Order(10)
	@DisplayName("TESTING NULL CHECK")
	public void testObjCreated() {
		assertNotNull(c);
	}
	
	@Order(20)
	@Test
	@DisplayName("TESTING MULTIPLY OPERATION")
	public void testMultiply() {
		actual = c.multiply(a, b);
		assertEquals(expected, actual);
	}

	@AfterEach
	public void clean() {
		c = null;
	}

}
