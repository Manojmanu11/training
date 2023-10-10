package com.example.teacherManagement.repository;

import com.example.teacherManagement.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class,Long> {
}
