package com.app.raghu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathServiceTest {
	
	MathService ms = null;
	int expected ;
	
	@BeforeEach
	public void setup() {
		ms = new MathService();
		expected = 30;
	}

	@Test
	public void testAdd() {
		int actual = ms.add(10, 20);
		assertEquals(expected, actual);
		boolean result = ms.isEven(51);
		assertTrue(result);
	}
	
	@AfterEach
	public void clean() {
		ms = null;
	}
}
