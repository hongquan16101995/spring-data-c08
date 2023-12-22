package com.example.data.service;

import com.example.data.model.Student;
import com.example.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

//    @Override
//    public void create(Student student) {
//        students.add(student);
//    }
//
//    @Override
//    public void update(Student student, Long id) {
//        Student detail = findById(id);
//        if (detail != null) {
//            detail.setName(student.getName());
//            detail.setGender(student.getGender());
//            detail.setAge(student.getAge());
//            detail.setAddress(student.getAddress());
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        Student detail = findById(id);
//        if (detail != null) {
//            students.remove(detail);
//        }
//    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }
//    @Override
//    public List<Student> sortByAge() {
//        students.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return (int) (o1.getAge() - o2.getAge());
//            }
//        });
//        return students;
//    }
//
//    @Override
//    public List<Student> findAllByGender(String gender) {
//        List<Student> studentList = new ArrayList<>();
//        for (Student s : students) {
//            if (s.getGender().equals(gender)) {
//                studentList.add(s);
//            }
//        }
//        return studentList;
//    }
}
