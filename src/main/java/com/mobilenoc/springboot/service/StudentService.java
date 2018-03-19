package com.mobilenoc.springboot.service;

import com.mobilenoc.springboot.entities.Student;
import com.mobilenoc.springboot.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>() ;
        studentRepository.findAll().forEach(students::add);
        return students ;
    }

    public Student getStudentById(Integer id){
        return studentRepository.findOne(id);
    }

    public void removeStudentById(Integer id) {
        studentRepository.delete(id);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudentByName(String name){
        return studentRepository.findByName(name);

    }
}
