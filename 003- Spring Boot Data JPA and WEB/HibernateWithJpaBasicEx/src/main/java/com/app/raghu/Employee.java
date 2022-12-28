package com.app.raghu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="emptab")
public class Employee {
  @Id
  @Column(name="eid")
  private Integer empId;
  @Column(name="ename")
  private String empName;
  @Column(name="esal")
  private Double empSal;
}