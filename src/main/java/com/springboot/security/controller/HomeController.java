package com.springboot.security.controller;

import com.springboot.security.model.User;
import com.springboot.security.repository.UserRepository;
import com.springboot.security.security.UserService;
import com.springboot.security.utility.CloudinaryConfig;
import com.springboot.security.model.SalesCourse;
import com.springboot.security.repository.SalesCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    CloudinaryConfig cloudc;
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/secure")
    public String secure(Principal principal, Model model) {

        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        return "secure";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "register";
        } else {
            userService.saveUser(user);
            model.addAttribute("message", "User Account Created");

        }
        return "index";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    /*course information*/

    @Autowired
    SalesCourseRepository courseRepository;

/*    @RequestMapping("/")
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "listCourse";
    }*/

    @GetMapping("/add")
    public String courseForm(Model model) {
        model.addAttribute("course", new SalesCourse());
        return "courseform";
    }

    @PostMapping("/process")
    public String processForm(@Valid SalesCourse course, BindingResult result) {
        if (result.hasErrors()) {
            return "courseform";
        }
        courseRepository.save(course);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("course", courseRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("course", courseRepository.findById(id).get());
        return "courseform";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id, Model model) {
        courseRepository.deleteById(id);
        return "redirect:/";
    }


}
