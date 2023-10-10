package com.example.teacherManagement.services;

import com.example.teacherManagement.entity.Class;
import com.example.teacherManagement.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile(value = {"local","dev","prod"})
public class ClassServiceImpl implements ClassService{

        @Autowired
        ClassRepository classRepository;

        public Class add(Class newClass){
            return   classRepository.save(newClass);
        }

        public List<Class> get() {
            return classRepository.findAll();

        }
    }


