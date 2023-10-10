package com.example.Logging.controller;

import com.example.Logging.entity.Student;
import com.example.Logging.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studentsOf")
@CacheConfig(cacheNames = "student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
   Logger logger=LoggerFactory.getLogger(StudentController.class);

    @PostMapping
    public Student add(@RequestBody Student student){
        return studentService.add(student);
    }
    @GetMapping
    public List<Student> getAll(){
        logger.info("logger info  enabled");
        logger.debug("logger debug enabled");
        return studentService.get();
    }
    @Cacheable(key = "#id")
    @GetMapping("/getById/{id}")
    public Optional<Student> getById(@PathVariable Integer id){
        logger.info(" the data fetch from student id" +id+"from cache");
        return studentService.findById(id);
    }
    @CachePut(key = "#id")
    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student student,@PathVariable Integer id){
        return studentService.update(id, student);
    }
    @CacheEvict(key = "#id")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }

}
