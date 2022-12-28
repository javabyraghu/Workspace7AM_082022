package com.app.raghu.entity;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer empId;
	private String empName;
	private Double empSal;
	
	private Address addr;//HAS-A
	
	private List<String> projects;
	private Map<String,Integer> codes;
	
}
