package com.app.raghu.entity;

//ctrl+shift+O
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="student_tab")
public class Student {
	@Id
	@Column(name="sid")
	private Integer stdId;
	
	@Column(name="sname")
	private String stdName;
	
	@Column(name="sfee")
	private Double stdFee;
	
}
