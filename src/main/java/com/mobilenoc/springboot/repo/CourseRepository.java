package com.mobilenoc.springboot.repo;

import com.mobilenoc.springboot.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
     List<Course> findByStudentId(Integer id);
}
