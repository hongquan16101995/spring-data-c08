package com.example.data.service;

import com.example.data.model.Student;

import java.util.List;

public interface IStudentService {
    void save(Student student);

    void delete(Long id);

    List<Student> findAll();

    List<Student> findAllByName(String name);

    Student findById(Long id);

    List<Student> sortByAge();

    List<Student> findAllByGender(String gender);
}
