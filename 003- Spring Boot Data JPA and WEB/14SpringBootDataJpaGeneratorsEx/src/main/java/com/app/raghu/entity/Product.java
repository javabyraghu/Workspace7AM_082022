package com.app.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="product_tab")
public class Product {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "test")
	@GenericGenerator(name="test",strategy = "com.app.raghu.gen.MyCustomGen")
	@Column(name="pid")
	private String prodId;
	
	@Column(name="pname")
	private String prodName;
	
	@Column(name="pcost")
	private Double prodCost;
	
}
