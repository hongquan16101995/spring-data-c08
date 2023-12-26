package com.example.data.controller;

import com.example.data.model.Student;
import com.example.data.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createGet() {
        ModelAndView modelAndView = new ModelAndView("/student/form");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/api/students";
    }

    @PostMapping("/search")
    public ModelAndView findName(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", studentService.findAllByName(name));
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable Long id) {
        Student student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/student/form");
        if (student != null) {
            modelAndView.addObject("student", student);
        } else {
            modelAndView.addObject("message", "Khong tim thay Student tuong ung");
        }
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id,
                             @ModelAttribute Student student) {
        Student detail = studentService.findById(id);
        if (detail != null) {
            student.setId(id);
            studentService.save(student);
        }
        return "redirect:/api/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/api/students";
    }

    @GetMapping("/sort")
    public ModelAndView sort() {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", studentService.sortByAge());
        return modelAndView;
    }

    @GetMapping("/gender")
    public ModelAndView filter(@RequestParam("g") String gender) {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", studentService.findAllByGender(gender));
        return modelAndView;
    }
}
