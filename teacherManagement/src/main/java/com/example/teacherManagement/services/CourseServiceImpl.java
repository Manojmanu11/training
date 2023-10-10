package com.example.teacherManagement.services;

import com.example.teacherManagement.entity.Course;
import com.example.teacherManagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    public Course add(Course course){
        return courseRepository.save(course);

    }
    public List<Course> getAllCourses(){
        return courseRepository.findAll();

    }
    public  void delete(Long id){
        courseRepository.deleteById(id);
    }


    public Course update(Long id,Course updateCourse){
        Optional<Course> optionalUser = courseRepository.findById(id);
        if (optionalUser.isPresent()) {
            Course course = optionalUser.get();
            course.setCName(updateCourse.getCName());
            return courseRepository.save(course);
        }
        return null;
    }

}
