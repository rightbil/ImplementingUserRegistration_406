package com.springboot.security.controller;

import com.springboot.security.model.User;
import com.springboot.security.repository.RoleRepository;
import com.springboot.security.repository.UserRepository;
import com.springboot.security.secure.UserService;
import com.springboot.security.utility.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class SecurityController {

    CloudinaryConfig cloudc;
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;


    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/listofusers")
    public String listAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "listofallusers";
    }

    @RequestMapping("/listofadminusers")
    public String listofAdmins(Model model) {
        model.addAttribute("adminroles", roleRepository.findByRole("ADMIN"));

        return "listofadmins";
    }

    @RequestMapping("/secure")
    public String secure(Principal principal, Model model) {

        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        return "secure";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "formforusers";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "formforusers";
        } else {
            userService.saveUser(user);
            model.addAttribute("message", "User Account Created");

        }
        return "home";
    }


}
