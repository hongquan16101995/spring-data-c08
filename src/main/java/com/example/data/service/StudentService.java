package com.example.data.service;

import com.example.data.model.Student;
import com.example.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public List<Student> findAllByName(String name) {
        return studentRepository.findAllByNameContaining(name);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    @Override
    public List<Student> sortByAge() {
        List<Student> students = findAll();
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getAge() - o2.getAge());
            }
        });
        return students;
    }

    @Override
    public List<Student> findAllByGender(String gender) {
        List<Student> students = findAll();
        List<Student> studentList = new ArrayList<>();
        for (Student s : students) {
            if (s.getGender().equals(gender)) {
                studentList.add(s);
            }
        }
        return studentList;
    }
}
