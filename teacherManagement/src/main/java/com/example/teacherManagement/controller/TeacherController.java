package com.example.teacherManagement.controller;

import com.example.teacherManagement.entity.ClassTeacher;
import com.example.teacherManagement.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping
    public ClassTeacher add(@RequestBody ClassTeacher teacher){
        return teacherService.add(teacher);
    }
    @GetMapping
    public List<ClassTeacher> getAll(){
        return teacherService.getAll();
    }
    @DeleteMapping
    public void   delete(@PathVariable Long id){
        teacherService.delete(id);
    }
    @PutMapping
    public ClassTeacher update(@PathVariable Long id, @RequestBody ClassTeacher teacher){
        return teacherService.update(id,teacher);
    }
}
