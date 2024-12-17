package com.example.SpringRedis_pet10.Model;

import com.example.SpringRedis_pet10.Model.Flower.Flower;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "visitors")
public class Visitor implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Visitor_Role role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "visitor_flower",
            joinColumns = @JoinColumn(name = "visitor_id"),
            inverseJoinColumns = @JoinColumn(name = "flower_id")
    )
    @JsonBackReference
    private Set<Flower> flowers = new HashSet<>();


    public Visitor() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Visitor_Role getRole() {
        return role;
    }

    public void setRole(Visitor_Role role) {
        this.role = role;
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(Set<Flower> flowers) {
        this.flowers = flowers;
    }
}
