package com.example.teacherManagement.services;

import com.example.teacherManagement.entity.Department;
import com.example.teacherManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department add(Department department) {
        return departmentRepository.save(department);

    }

    public List<Department> get() {
        return departmentRepository.findAll();
    }
}
