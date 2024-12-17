package com.example.SpringRedis_pet10.Repository;

import com.example.SpringRedis_pet10.Model.Flower.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer> {
}