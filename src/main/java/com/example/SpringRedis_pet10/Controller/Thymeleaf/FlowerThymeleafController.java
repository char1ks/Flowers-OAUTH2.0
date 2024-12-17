package com.example.SpringRedis_pet10.Controller.Thymeleaf;

import com.example.SpringRedis_pet10.Model.Flower.Flower;
import com.example.SpringRedis_pet10.Repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/flower")
public class FlowerThymeleafController {

    @Autowired
    private FlowerRepository flowerRepository;

    @GetMapping("/main")
    public String mainPage(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Flower> flowerPage = flowerRepository.findAll(pageable);
        model.addAttribute("flowers", flowerPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", flowerPage.getTotalPages());
        return "flower/mainPage";
    }

    @GetMapping("/concrete/{id}")
    public String concretePage() {
        return "flower/concretePage";
    }

    @GetMapping("/new")
    public String newPage() {
        return "flower/newPage";
    }
}