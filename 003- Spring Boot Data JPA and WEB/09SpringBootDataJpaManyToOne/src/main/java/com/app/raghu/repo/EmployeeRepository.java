package com.app.raghu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.raghu.entity.Employee;

public interface EmployeeRepository 
	extends JpaRepository<Employee, Integer> {
	

	@Query("SELECT emp.empName, dept.deptName FROM Employee emp INNER JOIN emp.dob as dept")
	List<Object[]> getEnameDeptNames();
	
	//@Query("SELECT emp.empName, dept.deptName FROM Employee emp LEFT OUTER JOIN emp.dob as dept")
	//@Query("SELECT emp.empName, dept.deptName FROM Employee emp LEFT OUTER JOIN emp.dob as dept WHERE dept IS NOT NULL")
	@Query("SELECT emp.empName, dept.deptName FROM Employee emp LEFT OUTER JOIN emp.dob as dept WHERE dept IS NULL")
	List<Object[]> getAllEnamesAndDeptNamesIfExist();
	
	//@Query("SELECT emp.empName, dept.deptName FROM Employee emp RIGHT OUTER JOIN emp.dob as dept")
	@Query("SELECT emp.empName, dept.deptName FROM Employee emp RIGHT OUTER JOIN emp.dob as dept WHERE emp IS NULL")
	List<Object[]> getAllDeptsAndEnamesIfExist();
	
	@Query("SELECT emp.empName, dept.deptName FROM Employee emp FULL JOIN emp.dob as dept")
	List<Object[]> getAllData();
	
	@Query("SELECT emp.empName, dept.deptName FROM Employee emp INNER JOIN emp.dob as dept WHERE dept.deptName=:deptName")
	List<Object[]> getEnameDeptNames(String deptName);
	
}
