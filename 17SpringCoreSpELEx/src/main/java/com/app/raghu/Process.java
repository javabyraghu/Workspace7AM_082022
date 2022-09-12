package com.app.raghu;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Process {
	
	//@Value("#{ 2 + 3 }")
	//@Value("#{ 'Hello ABC'.length()  }")
	//@Value("#{ new java.util.Random().nextInt() }")
	//@Value("#{ T(java.lang.Math).abs(-9)}")
	//@Value(" #{ T(java.lang.Math).abs( new java.util.Random().nextInt() ) }")
	//@Value(" #{ 'Hello'.length() > 0 ? 55 : 44 }")
	//@Value(" #{ modelData.model.length() }")
	//@Value(" #{ modelData.model.toLowerCase() }")
	@Value(" #{ modelData.model.replace('T','A') }")
	private String code;
	
	@Value("#{modelData.model.lines()}")
	private Stream<String> stream;
	
	@Value(" #{ modelData.model.getBytes() }")
	private byte[] arr;
	
	@Value(" #{ modelData.model.toCharArray() }")
	private char[] data;
	
	//@Value("#{ false }")
	//@Value(" #{ new java.util.Random().nextInt() > 5 ? true:false}")
	//@Value(" #{ new java.util.Random().nextInt() > 5 }")
	//@Value(" #{ new java.util.Random().nextInt() ge 5 }")
	//@Value(" #{ 5 % 2 > 0 && 2 + 3 le 5  }")
	@Value(" #{ 5 % 2 > 0 and 2 + 3 le 5  }")
	private boolean isPresent;

	@Override
	public String toString() {
		return "Process [code=" + code + ", stream=" + stream + ", arr=" + Arrays.toString(arr) + ", data="
				+ Arrays.toString(data) + ", isPresent=" + isPresent + "]";
	}

	
	

	

	
	
}
