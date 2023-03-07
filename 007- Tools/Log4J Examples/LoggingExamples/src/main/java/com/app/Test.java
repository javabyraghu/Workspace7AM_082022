package com.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

	private static final Logger LOG = LogManager.getLogger(Test.class);
	
	public static void main(String[] args) {
		LOG.error("FROM ERROR");
		LOG.info("FROM INFO");
		LOG.warn("FROM WARN");
		LOG.debug("FROM DEBUG");
		LOG.fatal("FROM FATAL");
	}
}
