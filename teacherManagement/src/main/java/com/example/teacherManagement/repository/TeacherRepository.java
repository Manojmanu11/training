package com.example.teacherManagement.repository;

import com.example.teacherManagement.entity.ClassTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<ClassTeacher,Long> {
}
