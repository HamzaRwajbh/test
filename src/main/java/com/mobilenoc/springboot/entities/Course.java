
package com.mobilenoc.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

    @Id
    private Integer id;
    private String name ;

    @ManyToOne
    private Student student ;

    public Course() {
    }

    public Course(Integer id, String name , Integer studentId) {
        this.id = id;
        this.name = name;
        this.student = new Student(studentId , "");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
