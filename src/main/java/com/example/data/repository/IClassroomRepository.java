package com.example.data.repository;

import com.example.data.model.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroomRepository extends CrudRepository<Classroom, Long> {
}
