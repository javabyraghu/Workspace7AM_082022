package com.app.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.Employee;

public interface EmployeeRepository
	extends JpaRepository<Employee, Integer>
{

}
