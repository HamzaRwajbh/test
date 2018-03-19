package com.mobilenoc.springboot.repo;

import com.mobilenoc.springboot.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByName(String name) ;
}
