package com.app.raghu.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	private Integer userId;
	
	@Column(name="uname")
	private String userName;
	
	@Column(name="umail")
	private String userEmail;
	
	@Column(name="upwd")
	private String userPwd;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="roles_tab",
		joinColumns = @JoinColumn(name="uid")
	)
	@Column(name="urole")
	private Set<String> userRoles;
	
}
