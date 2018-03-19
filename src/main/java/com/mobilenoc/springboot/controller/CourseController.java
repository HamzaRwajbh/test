package com.mobilenoc.springboot.controller;

import com.mobilenoc.springboot.entities.Course;
import com.mobilenoc.springboot.repo.CourseRepository;
import com.mobilenoc.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/{studentId}")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping()
    public List<Course> getCource(Integer id){
        return ;
    }

    @RequestMapping(value = "/course/{courseId}" , method = RequestMethod.GET)
    public Course getCourseById(@PathVariable("courseId") Integer id){
        return courseService.getCoursetById(id) ;
    }

    @RequestMapping(value = "/course/{courseId}" , method =  RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("courseId") Integer id){
        courseService.removeCourseById(id);
    }

    @RequestMapping(value = "/course" , method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

}
