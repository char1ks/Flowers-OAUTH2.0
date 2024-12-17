package com.example.SpringRedis_pet10.Repository;

import com.example.SpringRedis_pet10.Model.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
