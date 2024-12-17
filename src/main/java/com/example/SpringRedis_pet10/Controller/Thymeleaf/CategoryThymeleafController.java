package com.example.SpringRedis_pet10.Controller.Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryThymeleafController {

    @GetMapping("/new")
    public String newCategory(){
        return "category/newPage";
    }
}
