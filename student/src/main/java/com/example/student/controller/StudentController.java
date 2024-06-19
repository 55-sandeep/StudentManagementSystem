package com.example.student.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.example.student.model.Student;
import com.example.student.services.StudentService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentservice;
    @PostMapping("/students/bulk")
    public String addStudents(@RequestBody ArrayList<Student> al) {
        return studentservice.addStudents(al);
    }
    
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentservice.addStudent(student);
    }
    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        try{
        return studentservice.getStudents();
        }
        catch(Exception e){
            return new ArrayList<>();
        }
    }
    @GetMapping("/students/{studentid}")
    public Student getStudentById(@PathVariable("studentid") int studentid) {
        return studentservice.getStudentById(studentid);
    }
    @PutMapping("/students/{studentid}")
    public Student updateStudent(@PathVariable("studentid") int studentid, @RequestBody Student student) {
        return studentservice.updateStudent(studentid,student);
    }
    @DeleteMapping("/students/{studentid}")
    public void deleteStudent(@PathVariable("studentid") int studentid){
        studentservice.deleteStudent(studentid);
    }
}

