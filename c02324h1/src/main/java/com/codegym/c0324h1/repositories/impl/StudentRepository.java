package com.codegym.c0324h1.repositories.impl;

import com.codegym.c0324h1.models.Student;
import com.codegym.c0324h1.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "haiTT", "QN", 9.0f));
        students.add(new Student(2L, "haiTT2", "QN", 9.0f));
        students.add(new Student(3L, "haiTT3", "QN", 9.0f));

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size() - 1).getId() + 1);
        students.add(student);
    }

    @Override
    public Student findById(Long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                s.setName(student.getName());
                s.setAddress(student.getAddress());
                s.setScore(student.getScore());
                break;
            }
        }
    }
}
