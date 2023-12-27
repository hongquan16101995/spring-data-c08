package com.example.data.service.impl;

import com.example.data.model.Classroom;
import com.example.data.repository.IClassroomRepository;
import com.example.data.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService implements IClassroomService {

    @Autowired
    private IClassroomRepository classroomRepository;

    @Override
    public Iterable<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public void save(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    @Override
    public Classroom findOne(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }
}
