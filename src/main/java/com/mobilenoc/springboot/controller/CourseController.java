package com.mobilenoc.springboot.controller;

import com.mobilenoc.springboot.entities.Course;
import com.mobilenoc.springboot.entities.Student;
import com.mobilenoc.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student/{studentId}")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course" , method = RequestMethod.GET)
    public List<Course> getAllCources(@PathVariable("studentId") Integer id){
        return courseService.getAllCourse(id);
    }

    @RequestMapping(value = "/course/{courseId}" , method = RequestMethod.GET)
    public Course getCourseById(@PathVariable("courseId") Integer id){
        return courseService.getCourseById(id) ;
    }

    @RequestMapping(value = "/course" , method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course , @PathVariable("studentId") Integer studentId){
        System.out.println(course.getId());
        System.out.println(course.getName());
        System.out.println(studentId);
        course.setStudent(new Student(studentId , ""));
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/course/{courseId}" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void changeCourse(@PathVariable("courseId") Integer courseId ,@PathVariable("studentId") Integer studentId , @RequestBody Course course ){
        course.setStudent(new Student(studentId , ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(value = "/course/{courseId}" , method =  RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("courseId") Integer id){
        courseService.removeCourseById(id);
    }

}
