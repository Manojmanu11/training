package com.example.Logging.service;

import com.example.Logging.entity.Student;
import com.example.Logging.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class StudentServiceImpl  implements StudentService{

   StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

    public Student add(Student student){
        return studentRepository.save(student);
    }
    public List<Student> get(){
        return  studentRepository.findAll();
    }
    public Optional<Student> findById(int id){
        return studentRepository.findById(id);
    }
    public OptionalDouble delete(int id){
        studentRepository.deleteById(id);
        return null;
    }
    public Student update(Integer id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student user = optionalStudent.get();
            user.setName(updatedStudent.getName());
            user.setAge(updatedStudent.getAge());
            user.setGender(updatedStudent.getGender());
            return studentRepository.save(user);
        }
        return null;
    }


}
