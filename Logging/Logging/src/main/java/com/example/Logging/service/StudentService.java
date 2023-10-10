package com.example.Logging.service;

import com.example.Logging.entity.Student;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface StudentService {
    public Student add(Student student);
    public List<Student> get();
    public Optional<Student> findById(int id);
    public OptionalDouble delete(int id);
    public Student update(Integer id, Student updatedStudent);
}
