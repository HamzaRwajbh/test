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

    @RequestMapping(value = "/{name}" , method = RequestMethod.GET)
    public List<Student> getStudentByName(@PathVariable("name") String name){
        return studentService.getStudentByName(name);
    }

    @RequestMapping(method = RequestMethod.POST )
    public void addstudent(
            @RequestParam("id") int id ,
            @RequestParam("name") String name ){
        studentService.addStudent(new Student(id,name)) ;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void changeCourse(@PathVariable("id") String Id , @RequestBody Student student ){
        studentService.updateStudent(student);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void removeStudentById(@PathVariable("id") int id){
        studentService.removeStudentById(id);
    }
}
