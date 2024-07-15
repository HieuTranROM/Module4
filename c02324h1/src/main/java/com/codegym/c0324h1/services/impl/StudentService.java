package com.codegym.c0324h1.services.impl;

import com.codegym.c0324h1.models.Student;
import com.codegym.c0324h1.repositories.IStudentRepository;
import com.codegym.c0324h1.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }
}
