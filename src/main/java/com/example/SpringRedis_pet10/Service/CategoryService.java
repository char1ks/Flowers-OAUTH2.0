package com.example.SpringRedis_pet10.Service;

import com.example.SpringRedis_pet10.Model.Category.Category;
import com.example.SpringRedis_pet10.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository operations;

    public List<Category> getAllCategories(){
        return operations.findAll();
    }
    public Category getConcreteCategory(int id){
        return operations.findById(id).orElse(null);
    }
    public Category saveCategory(Category category){
        return operations.save(category);
    }
    public void deleteCategory(int id){
        operations.deleteById(id);
    }
}
