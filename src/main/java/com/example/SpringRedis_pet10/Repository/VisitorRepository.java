package com.example.SpringRedis_pet10.Repository;

import com.example.SpringRedis_pet10.Model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Integer> {
    Visitor findByUsername(String username);
}
