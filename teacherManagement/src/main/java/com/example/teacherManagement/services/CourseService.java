package com.example.teacherManagement.services;

import com.example.teacherManagement.entity.Course;

import java.util.List;

public interface CourseService {
    Course add(Course course);
    List<Course> getAllCourses();
    void delete(Long id);
    Course update(Long id,Course updateCourse);
}
