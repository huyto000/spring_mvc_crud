package com.dao;

import com.entities.Student;

import java.util.List;

public interface StudentDao {
    public int create(Student student);
    public List<Student> read();
    public Student findStudentById(int id);
    public int updateStudent(Student student);
    public int deleteStudent(int id);
}
