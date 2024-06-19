package com.example.student.model;

import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs,int rowNum) throws SQLException{
        return new Student(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("gender"),
            rs.getInt("standard")
        );
    }
}
