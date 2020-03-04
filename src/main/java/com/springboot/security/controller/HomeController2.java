package com.springboot.security.controller;

import org.springframework.stereotype.Controller;


public class HomeController2 {
   /* @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public CarRepository carRepository;
    @Autowired
    CloudinaryConfig cloudc;

    // TODO: Home page Car listings by category
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "carlists";
    }

    //TODO: 1.1 Add Category
    @RequestMapping(value = "/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
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
        return "carForm";
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
        return "categoryForm";
    }

    //TODO: 3.2 Update Car
    @RequestMapping("/updateCar/{id}")
    public String upateCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        model.addAttribute("catgs", categoryRepository.findAll());
        return "carForm";
    }

    @RequestMapping("/listCategory")
    public String listCategory(Model model) {
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "listCategory";
    }

    @RequestMapping("/listCars")
    public String listCars(Model model) {
        model.addAttribute("carLists", carRepository.findAll());
        return "listCars";
    }
*/

    //TODO: Version One
    /*Grading Criteria:
    Add categories
    Add cars
    When adding cars, assign a category to that car
    Update car information
    Delete cars
    View car details
    List cars that were added
    List categories
    */
    //TODO: Version Two
    /*
    If finished, proceed to additional criteria:
    When the user clicks on a category, they will be given a list of cars under that category
    Add cars with photos (Cloudinary optional)
    Update photos of cars
    Deploy your application to Heroku after you switch the database to PostgreSQL.
*/
}
