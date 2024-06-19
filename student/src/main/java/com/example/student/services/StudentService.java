package com.example.student.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.model.StudentRowMapper;
@Service
public class StudentService implements StudentRepository {
    @Autowired
    private JdbcTemplate db;
    @Override
    public Student updateStudent(int studentId,Student stu){
        if(stu.getStudentName()!=null){
        db.update("update student set name = ? where id = ?",stu.getStudentName(),studentId);
        }
        if(stu.getGender()!=null){
            db.update("update student set gender = ? where id=?", stu.getGender(),studentId);
        }
        if(stu.getStandard()!=0){
            db.update("update student set standard = ? where id=?", stu.getStandard(),studentId);
        }
        return getStudentById(studentId);
    }
    @Override
    public Student addStudent(Student student){
        db.update("insert into student(name,gender,standard) values (?,?,?)",
        student.getStudentName(),student.getGender(),student.getStandard());
        Student added = db.queryForObject("select * from student where name = ? and gender=? and standard=?",new StudentRowMapper(),
        student.getStudentName(),student.getGender(),student.getStandard());
        return added;
    }
    @Override
    public String addStudents(ArrayList<Student> al){
        int count = 0;
        for(Student student: al){
            db.update("insert into student(name,gender,standard) values (?,?,?)",student.getStudentName(),
            student.getGender(),student.getStandard());
            count++;
        }
        return "Successfully added  "+count+" students";
    }
    @Override
    public void deleteStudent(int studentid){
        db.update("delete from student where id = ?", studentid);
    }
    @Override
    public Student getStudentById(int studentid){
        Student student = db.queryForObject("select * from student where id = ?",new StudentRowMapper(),studentid);
        return student;
    }
    @Override
    public ArrayList<Student> getStudents(){
        List<Student> li = db.query("select * from student",new StudentRowMapper());
        ArrayList<Student> students = new ArrayList<>(li);
        return students;
    }
}
