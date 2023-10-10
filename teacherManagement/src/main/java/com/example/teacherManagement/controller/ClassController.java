package com.example.teacherManagement.controller;

import com.example.teacherManagement.entity.Class;
import com.example.teacherManagement.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;
    @PostMapping
    public Class add(@RequestBody Class newclass){
        return classService.add(newclass);
    }
    @GetMapping
    public List<Class> getAll(){
        return classService.get();
    }

}
