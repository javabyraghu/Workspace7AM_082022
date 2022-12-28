package com.app.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_tab")
public class Product {
	
	@Id
	@Column(name="pid")
	private Integer prodId;
	
	@Column(name="pname")
	private String prodName;
	@Column(name="pcost")
	private Double prodCost;
	
}
