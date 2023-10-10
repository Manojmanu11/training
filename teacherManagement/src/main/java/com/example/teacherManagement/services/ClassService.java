package com.example.teacherManagement.services;
import com.example.teacherManagement.entity.Class;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClassService{
  Class add(Class newClass);
  List<Class>get();
}
