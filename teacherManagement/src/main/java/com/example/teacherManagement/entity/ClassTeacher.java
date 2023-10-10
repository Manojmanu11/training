package com.example.teacherManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher_db")
@Entity
public class ClassTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    @OneToOne(mappedBy = "classTeacher")
    private Class aClass;

}
