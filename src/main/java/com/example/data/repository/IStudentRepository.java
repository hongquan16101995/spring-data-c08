package com.example.data.repository;

import com.example.data.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {
    // select * from students where name like %<name>%
    // select s from Student s where s.name like %:name%
    List<Student> findAllByNameContaining(String name);

    List<Student> findByOrderByAgeAsc();

    List<Student> findAllByGender(String gender);
}
