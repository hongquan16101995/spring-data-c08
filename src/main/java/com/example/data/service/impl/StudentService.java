package com.example.data.service.impl;

import com.example.data.model.Student;
import com.example.data.repository.IStudentRepository;
import com.example.data.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findOne(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAllByName(String name) {
        return studentRepository.findAllByNameContaining(name);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> sortByAge() {
        return studentRepository.findByOrderByAgeAsc();
    }

    @Override
    public List<Student> findAllByGender(String gender) {
        return studentRepository.findAllByGender(gender);
    }
}
