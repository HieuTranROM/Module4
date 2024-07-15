package com.codegym.c0324h1.repositories;

import com.codegym.c0324h1.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Student findById(Long id);

    void update(Student student);
}
