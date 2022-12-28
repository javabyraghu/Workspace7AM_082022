package com.app.raghu.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.raghu.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

}
