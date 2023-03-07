package com.app.raghu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class TestMockProcessInfo {
	@Test
	public void testInfo() {
		ProcessInfo ps = mock(ProcessInfo.class);
		when(ps.getCode("ABC")).thenReturn(100);
		
		assertEquals(ps.getCode("ABC"), 100);
	}
}
