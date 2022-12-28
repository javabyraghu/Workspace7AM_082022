package com.app.raghu.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="prodtab")
public class Product {
	@Id
	@Column(name="pid")
	private Integer prodId;
	@Column(name="pcode")
	private String prodCode;
	
	@ElementCollection
	private List<String> colors;
	
	@ElementCollection
	private Set<String> models;
	
	@ElementCollection //must 
	private Map<String,String> details;
	
	
}
