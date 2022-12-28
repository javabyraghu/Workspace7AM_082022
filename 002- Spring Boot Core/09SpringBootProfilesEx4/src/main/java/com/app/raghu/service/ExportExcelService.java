package com.app.raghu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Component
@Profile({"default","qa"})
public class ExportExcelService {
	
	@Value("csv")
	private String extCode;
	
	@Value("#{new java.util.Random().nextInt()}")
	private Integer formatId;
	
}
