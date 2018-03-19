package com.mobilenoc.springboot.controller;

import com.mobilenoc.springboot.entities.Student;
import com.mobilenoc.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final String controllerName = "StudentController";

    @Autowired
    private StudentService studentService ;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllStudents() {
        return new ResponseEntity(studentService.getAllStudents() , HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void removeStudentById(@PathVariable("id") int id){
        studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.POST )
    public void addstudent(
            @RequestParam("id") int id ,
            @RequestParam("name") String name ,
            @RequestParam("course") String course) {
        studentService.addStudent(new Student(id,name,course)) ;
    }

    @RequestMapping(value = "/{name}" , method = RequestMethod.GET)
    public List<Student> getStudentByName(@PathVariable("name") String name){
        System.out.println(name);
        return studentService.getStudentByName(name);
    }

    @RequestMapping(value = "/{name}" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean changeCourse(@PathVariable("name") String studentName , @RequestBody Student student ){
        return true;
    }
}
