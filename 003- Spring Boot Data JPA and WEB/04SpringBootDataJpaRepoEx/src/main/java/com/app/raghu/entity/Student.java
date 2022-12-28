package com.app.raghu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="stdtab")
public class Student {
	@Id
	@Column(name="sid")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE) //oracle
	//@GeneratedValue(strategy = GenerationType.TABLE) //temp table to store next PK val
	@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql (Auto increment)
	private Integer stdId;
	
	@Column(name="sname")
	private String stdName;
	@Column(name="sfee")
	private Double stdFee;
	
	@Column(name="sdoj")
	//@Temporal(TemporalType.DATE)//stores only date
	//@Temporal(TemporalType.TIME)//stores only time
	@Temporal(TemporalType.TIMESTAMP)//stores both and time (default)
	private Date stdDoj;
}
