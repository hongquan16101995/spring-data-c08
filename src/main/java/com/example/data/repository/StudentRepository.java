package com.example.data.repository;

import com.example.data.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    // select * from students where name like %<name>%
    // select s from Student s where s.name like %:name%
    List<Student> findAllByNameContaining(String name);
}
