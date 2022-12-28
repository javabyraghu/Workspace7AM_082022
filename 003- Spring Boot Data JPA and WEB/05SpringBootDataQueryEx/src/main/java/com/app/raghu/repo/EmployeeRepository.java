package com.app.raghu.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.raghu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//@Query("_________")
	//ReturnType  abstractMethodName(<Param>)
	/**
	 * This abstractMethodName can be any name...
	 * 
	 */

	//SQL: 1. fetch one column data
	@Query("SELECT e.empName FROM Employee e")
	//@Query("SELECT empName FROM Employee")
	List<String> getAllEmpNames();
	
	//SQL: 2 select all columns
	@Query("SELECT e FROM Employee e")
	//@Query("FROM Employee e")
	List<Employee> fetchAllEmps();
	
	//SQL: 3 select multiple columns
	@Query("SELECT e.empId, e.empName FROM Employee e")
	List<Object[]> fetchIdAndNames();
	
	//SQL:4 Fetch one column and one row data
	@Query("SELECT e.empName FROM Employee e WHERE e.empId=:id")
	Optional<String> getEmpNameById(Integer id);
	
	//SQL:5 fetch all columns and one row
	@Query("SELECT e FROM Employee e WHERE e.empId=:empId")
	Optional<Employee> fetchEmployeeById(Integer empId);
	
	
	
}
