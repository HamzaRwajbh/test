package com.mobilenoc.springboot.service;

import com.mobilenoc.springboot.entities.Course;
import com.mobilenoc.springboot.entities.Student;
import com.mobilenoc.springboot.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse(Integer id) {
        List<Course> courses = new ArrayList<>() ;
        courseRepository.findByStudentId(id).forEach(courses::add);
        return courses ;
    }

    public Course getCourseById(Integer id){
        return courseRepository.findOne(id);
    }

    public void removeCourseById(Integer id) {
        courseRepository.delete(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }
}
