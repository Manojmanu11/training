package com.example.teacherManagement.services;

import com.example.teacherManagement.entity.Student;

import java.util.List;

public interface StudentService {
    Student add(Student student);
    List<Student> get();
}
