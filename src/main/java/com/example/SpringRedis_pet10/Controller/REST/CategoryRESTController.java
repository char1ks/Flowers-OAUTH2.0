package com.example.SpringRedis_pet10.Controller.REST;

import com.example.SpringRedis_pet10.Model.Category.Category;
import com.example.SpringRedis_pet10.Model.Flower.Flower;
import com.example.SpringRedis_pet10.Service.CategoryService;
import com.example.SpringRedis_pet10.Service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Flow;

@RestController
@RequestMapping("/category/api")
public class CategoryRESTController {

    @Autowired
    private CategoryService operations;

    @Autowired
    private FlowerService operationsFlower;

    @GetMapping("/all")
    public List<Category> allCategories(){
        return operations.getAllCategories();
    }
    @GetMapping("/concrete/{id}")
    public Category concrete(@PathVariable("id")int id){
        return operations.getConcreteCategory(id);
    }
    @PostMapping("/save")
    private ResponseEntity<HttpStatus> saveCategory(@RequestBody Category category){
        operations.saveCategory(category);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id")int id){
        operations.deleteCategory(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/flower_category/{flower_id}/{category_id}")
    public ResponseEntity<HttpStatus> flowerToCategory(@PathVariable("flower_id") int flower_id, @PathVariable("category_id") int category_id) {
        Flower flower = operationsFlower.getConcreteFlower(flower_id);
        Category category = operations.getConcreteCategory(category_id);

        // Check if the category is already associated with the flower
        if (!flower.getCategories().contains(category)) {
            flower.getCategories().add(category);
            category.getFlowers().add(flower);

            operations.saveCategory(category);
        }
        else
            System.out.println("Какая-то хуйня");
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
