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
@Table(name="coursetab")
public class Course {
	@Id
	@Column(name="cid")
	private Integer courseId;
	@Column(name="cname")
	private String courseName;
	@Column(name="cfee")
	private Double courseFee;
}
