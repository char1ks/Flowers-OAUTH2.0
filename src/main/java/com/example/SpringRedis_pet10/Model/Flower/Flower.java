package com.example.SpringRedis_pet10.Model.Flower;

import com.example.SpringRedis_pet10.Model.Category.Category;
import com.example.SpringRedis_pet10.Model.Visitor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flowers")
public class Flower implements Serializable {
    private static final long serialVersionUID = 1L; // Уникальный идентификатор

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "availability", nullable = false)
    private boolean availability;

    @Column(name = "description")
    private String description;

    @Column(name = "flower_type")
    @Enumerated(EnumType.STRING)
    private FlowerType type;

    @ManyToMany(mappedBy = "flowers", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Visitor> visitors = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "flower_category",
            joinColumns = @JoinColumn(name = "flower_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonBackReference
    private Set<Category> categories = new HashSet<>();

    // Конструкторы, геттеры и сеттеры
    public Flower() {}

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
    }

    public FlowerType getType() {
        return type;
    }

    public void setType(FlowerType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(Set<Visitor> visitors) {
        this.visitors = visitors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}