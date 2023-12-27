package com.example.data.service;

import com.example.data.model.Student;

import java.util.List;

public interface IStudentService extends IGenerateService<Student> {
    void delete(Long id);

    List<Student> findAllByName(String name);

    List<Student> sortByAge();

    List<Student> findAllByGender(String gender);
}
