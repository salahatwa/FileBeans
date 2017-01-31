package com.salahatwa.testLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
	
	private static Logger LOGGER=LoggerFactory.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		LOGGER.info("welcome");
	}

}
