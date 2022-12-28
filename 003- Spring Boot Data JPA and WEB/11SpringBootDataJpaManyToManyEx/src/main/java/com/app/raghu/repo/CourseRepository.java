package com.app.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
