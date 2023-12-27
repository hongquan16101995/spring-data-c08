package com.example.data.formatter;

import com.example.data.model.Classroom;
import com.example.data.service.IClassroomService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ClassroomFormatter implements Formatter<Classroom> {

    private final IClassroomService classroomService;

    public ClassroomFormatter(IClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @Override
    public Classroom parse(String text, Locale locale) {
        return classroomService.findOne(Long.parseLong(text));
    }

    @Override
    public String print(Classroom object, Locale locale) {
        return object.toString();
    }
}
