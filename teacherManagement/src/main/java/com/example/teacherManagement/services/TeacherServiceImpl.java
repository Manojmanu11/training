package com.example.teacherManagement.services;

import com.example.teacherManagement.entity.ClassTeacher;
import com.example.teacherManagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;


    public ClassTeacher add(ClassTeacher teacher){
        return teacherRepository.save(teacher);
    }

    public List<ClassTeacher> getAll(){
        return teacherRepository.findAll();

    }
    public void delete(Long id){
        teacherRepository.deleteById(id);
    }

    public ClassTeacher update(Long id, ClassTeacher updateTeacher){
        Optional<ClassTeacher> optionalUser = teacherRepository.findById(id);
        if (optionalUser.isPresent()) {
            ClassTeacher teacher1 = optionalUser.get();
            teacher1.setName(updateTeacher.getName());
            return teacherRepository.save(teacher1);
        }
        return null;
    }
}
