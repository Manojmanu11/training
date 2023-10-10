package com.example.teacherManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cname;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_classTeacher_id")
    private ClassTeacher classTeacher;





}
