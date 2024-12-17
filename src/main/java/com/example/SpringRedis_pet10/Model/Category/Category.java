package com.example.SpringRedis_pet10.Model.Category;

import com.example.SpringRedis_pet10.Model.Flower.Flower;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt; // Дата создания категории

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt; // Дата последнего обновления категории

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "flower_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "flower_id")
    )
    private Set<Flower> flowers = new HashSet<>();

    // Конструкторы, геттеры и сеттеры
    public Category() {
        this.createdAt = java.time.LocalDateTime.now(); // Устанавливаем дату создания при создании категории
        this.updatedAt = java.time.LocalDateTime.now(); // Устанавливаем дату обновления при создании категории
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updatedAt = java.time.LocalDateTime.now(); // Обновляем дату при изменении имени
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = java.time.LocalDateTime.now(); // Обновляем дату при изменении описания
    }

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public java.time.LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(Set<Flower> flowers) {
        this.flowers = flowers;
        this.updatedAt = java.time.LocalDateTime.now(); // Обновляем дату при изменении связанных цветов
    }
}