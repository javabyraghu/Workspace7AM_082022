package com.app.raghu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usertab")
public class User {
	@Id
	@Column(name="uid")
	private Integer userId;
	@Column(name="uname")
	private String userName;
	
	@ManyToOne
	//@JoinColumn(name="ridFk",unique = true,nullable = false)
	@JoinColumn(name="ridFk",unique = true)
	private Role rob;
}
