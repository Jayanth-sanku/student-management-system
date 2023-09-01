package com.studentmanagement.dao;

import com.studentmanagement.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    void addStudent(Student student);
    Student getStudentById(int id);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
