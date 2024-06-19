package com.example.student.repository;
import java.util.*;
import com.example.student.model.Student;

public interface StudentRepository {
    
    ArrayList<Student> getStudents();
    Student getStudentById(int studentId);
    Student updateStudent(int studentid,Student stu);
    void deleteStudent(int studentid);
    Student addStudent(Student student);
    String addStudents(ArrayList<Student> student);
} 
