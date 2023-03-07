package com.app.raghu;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.sql.Connection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConnectionUtilTest {

	Connection con1, con2;
	
	@BeforeEach
	public void setup() {
		con1 = ConnectionUtil.getConnection();
		con2 = ConnectionUtil.getConnection();
	}
	
	@Test
	@Disabled
	@DisplayName("CHECKING NOT NULL")
	@Order(1)
	public void testNotNull() {
		assertAll(
				()->assertNotNull(con1),
				()->assertNotNull(con2)
				);
	}
	
	@Test
	@DisplayName("CHECKING SAME REF")
	@Order(2)
	public void testSameRef() {
		assertSame(con1, con2);
	}
	
	@AfterEach
	public void clean() {
		con1 = con2  = null;
	}
	
}
