package com.example.data.controller;

import com.example.data.model.Classroom;
import com.example.data.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/classrooms")
public class ClassroomController {
    @Autowired
    private IClassroomService classroomService;

    @GetMapping
    public ModelAndView findAll() {
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
}
