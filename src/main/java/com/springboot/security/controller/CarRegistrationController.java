package com.springboot.security.controller;

import com.cloudinary.utils.ObjectUtils;
import com.springboot.security.model.Car;
import com.springboot.security.model.Category;
import com.springboot.security.repository.CarRepository;
import com.springboot.security.repository.CategoryRepository;
import com.springboot.security.utility.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class CarRegistrationController {
    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public CarRepository carRepository;
    @Autowired
    CloudinaryConfig cloudc;

     //TODO: 1.1 Add Category
    @RequestMapping(value = "/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "formforcategory";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute Category dept, Model model) {
        categoryRepository.save(dept);
        return "redirect:/";
    }

    //TODO: 1.2 Add Car
    @RequestMapping(value = "/addCar")
    public String addCar(Model model) {
        model.addAttribute("catgs", categoryRepository.findAll());
        model.addAttribute("car", new Car());
        return "formforcar";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String addCar(@ModelAttribute Car car, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "redirect:/addCar";
        }
        try {

            Map uploadResult = cloudc.upload(file.getBytes(),
                    ObjectUtils.asMap("resourcetype", "auto"));
            car.setImage(uploadResult.get("url").toString());
            carRepository.save(car);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/addCar";

        }
        return "redirect:/";
    }
    //TODO: 2.1 Delete Category

    @RequestMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        categoryRepository.deleteById(id);
        return "redirect:/";
    }

    //TODO: 2.2 Delete Car
    @RequestMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable("id") long id) {
        carRepository.deleteById(id);
        return "redirect:/";
    }

    //TODO: 3.1 Update Category
    @RequestMapping("/updateCategory/{id}")
    public String upateCategory(@PathVariable("id") long id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "formforcategory";
    }

    //TODO: 3.2 Update Car
    @RequestMapping("/updateCar/{id}")
    public String upateCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        model.addAttribute("catgs", categoryRepository.findAll());
        return "formforcar";
    }

    @RequestMapping("/listCategory")
    public String listCategory(Model model) {
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "listofcategory";
    }

    @RequestMapping("/listCars")
    public String listCars(Model model) {
        model.addAttribute("carLists", carRepository.findAll());
        return "listofcar";
    }

}
