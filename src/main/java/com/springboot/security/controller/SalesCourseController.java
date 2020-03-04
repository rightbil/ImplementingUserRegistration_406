package com.springboot.security.controller;

import com.springboot.security.model.SalesCourse;
import com.springboot.security.repository.SalesCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

public class SalesCourseController {

    @Autowired
    SalesCourseRepository courseRepository;

    @GetMapping("/add")
    public String courseForm(Model model) {
        model.addAttribute("course", new SalesCourse());
        return "formforcourse";
    }

    @PostMapping("/process")
    public String processForm(@Valid SalesCourse course, BindingResult result) {
        if (result.hasErrors()) {
            return "formforcourse";
        }
        courseRepository.save(course);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("course", courseRepository.findById(id).get());
        return "showacourse";
    }

    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("course", courseRepository.findById(id).get());
        return "formforcourse";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id, Model model) {
        courseRepository.deleteById(id);
        return "redirect:/";
    }
}