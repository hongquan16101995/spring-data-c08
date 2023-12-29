package com.example.data.service;

import com.example.data.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService extends IGenerateService<Student> {
    void delete(Long id);

    List<Student> findAllByName(String name);

    List<Student> sortByAge();

    List<Student> findAllByGender(String gender);

    //đối tượng Page: trả về 1 page chứa số lượng phần tử như mong muốn
    Page<Student> findAllPage(Pageable pageable);
}
