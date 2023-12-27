package com.example.data.controller;

import com.example.data.model.Classroom;
import com.example.data.model.Student;
import com.example.data.service.IClassroomService;
import com.example.data.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassroomService classroomService;

    @ModelAttribute("classrooms")
    private Iterable<Classroom> getClassrooms() {
        return classroomService.findAll();
    }

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
    public ModelAndView createPost(@Valid @ModelAttribute Student student,
                             BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/student/form");
            modelAndView.addObject("student", student);
            return modelAndView;
        } else {
            studentService.save(student);
            ModelAndView modelAndView = new ModelAndView("/student/list");
            modelAndView.addObject("student", studentService.findAll());
            return modelAndView;
        }
    }

    @PostMapping("/search")
    public ModelAndView findName(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", studentService.findAllByName(name));
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable Long id) {
        Student student = studentService.findOne(id);
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
        Student detail = studentService.findOne(id);
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
