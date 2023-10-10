package com.example.teacherManagement.services;

import com.example.teacherManagement.entity.Student;
import com.example.teacherManagement.exceptions.UserExistException;
import com.example.teacherManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student add(Student student){
        if(!studentRepository.findByName(student.getName()).isEmpty()){
            throw new UserExistException("username already exists");
        }
        return   studentRepository.save(student);

    }
    public List<Student> get(){
        return studentRepository.findAll();
    }
}
