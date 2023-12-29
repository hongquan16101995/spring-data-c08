package com.example.data.controller;

import com.example.data.model.Classroom;
import com.example.data.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/classrooms")
public class ClassroomController {
    @Autowired
    private IClassroomService classroomService;

    @GetMapping
    public ModelAndView findAll(@SessionAttribute(name = "classrooms", required = false) Iterable<Classroom> classrooms) {
        System.out.println(classrooms);
        ModelAndView modelAndView = new ModelAndView("/classroom/list");
        modelAndView.addObject("classrooms", classroomService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createGet() {
        ModelAndView modelAndView = new ModelAndView("/classroom/form");
        modelAndView.addObject("classroom", new Classroom());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Classroom classroom) {
        classroomService.save(classroom);
        return "redirect:/api/classrooms";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/classroom/form");
        modelAndView.addObject("classroom", classroomService.findOne(id));
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String updatePost(@ModelAttribute Classroom classroom) {
        classroomService.save(classroom);
        return "redirect:/api/classrooms";
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView getError() {
        return new ModelAndView("/error");
    }
}
