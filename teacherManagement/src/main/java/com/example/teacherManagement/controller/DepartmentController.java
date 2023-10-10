package com.example.teacherManagement.controller;

import com.example.teacherManagement.entity.Department;
import com.example.teacherManagement.services.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class DepartmentController {
    public  static  final Logger logger= LogManager.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;
    @PostMapping
    public Department add(@RequestBody Department department){
        return departmentService.add(department);
    }
    @GetMapping
    public List<Department> getAll(){
        logger.info("fetched department details");

        return departmentService.get();
    }




//    @DeleteMapping
//    public void   delete(@PathVariable Long id){
//         courseService.delete(id);
//    }
//    @PutMapping
//    public Course update(@PathVariable Long id,@RequestBody Course course){
//        return courseService.update(id,course);
//    }
}
