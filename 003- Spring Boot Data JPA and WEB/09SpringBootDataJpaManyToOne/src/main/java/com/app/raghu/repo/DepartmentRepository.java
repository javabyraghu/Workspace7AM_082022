package com.app.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.raghu.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	//2 columns 1 row
	@Query("SELECT d.deptAdmin,d.deptName FROM Department d WHERE d.deptId=:did")
	Object getSomeData(Integer did);
	
}
