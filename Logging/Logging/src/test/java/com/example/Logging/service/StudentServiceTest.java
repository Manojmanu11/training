package com.example.Logging.service;

import com.example.Logging.entity.Student;
import com.example.Logging.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    private StudentService studentService;
    AutoCloseable autoCloseable;
    private Student student;
     private Student updatedStudent;
    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        studentService=new StudentServiceImpl(studentRepository);
        student =new Student(1,"manoj",22,"male");
         updatedStudent=new Student(1,"manu",22,"male");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void add() {
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.save(student)).thenReturn(student);
        assertThat(studentService.add(student)).isEqualTo(student);
    }

    @Test
    void get() {
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.findAll()).thenReturn(new ArrayList<Student>(
                Collections.singleton(student)
        ));

        assertThat(studentService.get().get(0).getName()).
                isEqualTo(student.getName());

    }

    @Test
    void findById() {
        mock(Student.class);
        mock(StudentRepository.class);

        when(studentRepository.findById(1)).thenReturn(Optional.ofNullable(student));
        assertThat(studentService.findById(1).get().getName()).isEqualTo(student.getName());
    }

    @Test
    void delete() {

        mock(Student.class);
        mock(StudentRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(studentRepository)
                .deleteById(any());
        assertThat(studentService.delete(1)).isEqualTo(null);
    }

    @Test
    void update() {

        StudentRepository studentRepositoryMock = mock(StudentRepository.class);
        StudentService studentService = new StudentServiceImpl(studentRepositoryMock);
        Student student = new Student(1, "manoj", 22, "male");
        Student updatedStudent = new Student(1, "sharan", 25, "male");
        when(studentRepositoryMock.findById(1)).thenReturn(Optional.of(student));
        when(studentRepositoryMock.save(any(Student.class))).thenReturn(updatedStudent);
        Student result = studentService.update(1, updatedStudent);
        verify(studentRepositoryMock).save(updatedStudent);
        assertThat(result).isEqualTo(updatedStudent);
    }


}
