package com.mobilenoc.springboot.service;

import com.mobilenoc.springboot.entities.Course;
import com.mobilenoc.springboot.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        List<Course> students = new ArrayList<>() ;
        courseRepository.findAll().forEach(students::add);
        return students ;
    }

    public Course getCoursetById(Integer id){
        return courseRepository.findOne(id);
    }

    public void removeCourseById(Integer id) {
        courseRepository.delete(id);
    }

    public void addCourse(Course student) {
        courseRepository.save(student);
    }

}
