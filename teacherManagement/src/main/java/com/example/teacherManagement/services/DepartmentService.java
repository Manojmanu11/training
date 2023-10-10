package com.example.teacherManagement.services;

import com.example.teacherManagement.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department add(Department department);
    List<Department> get();
}
