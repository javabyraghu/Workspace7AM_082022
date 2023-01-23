package com.app.raghu.util;

import com.app.raghu.entity.StockInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static StockInfo convertToObj(String message) {
		try {
			return new ObjectMapper().readValue(message, StockInfo.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String convertToString(StockInfo si) {
		try {
			return new ObjectMapper().writeValueAsString(si);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
