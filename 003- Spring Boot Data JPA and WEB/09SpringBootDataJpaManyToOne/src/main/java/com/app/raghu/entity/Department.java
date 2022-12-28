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
@Table(name="depttab")
public class Department {
	@Id
	@Column(name="did")
	private Integer deptId;
	@Column(name="dname")
	private String deptName;
	@Column(name="dadmin")
	private String deptAdmin;
}
