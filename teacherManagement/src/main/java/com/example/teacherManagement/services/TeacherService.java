package com.example.teacherManagement.services;

import com.example.teacherManagement.entity.ClassTeacher;

import java.util.List;

public interface TeacherService {
    ClassTeacher add(ClassTeacher teacher);
    List<ClassTeacher> getAll();
    void delete(Long id);
    ClassTeacher update(Long id, ClassTeacher updateTeacher);
}
