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
@Table(name="roletab")
public class Role {
	@Id
	@Column(name="rid")
	private Integer roleId;
	@Column(name="rcode")
	private String roleCode;
}
