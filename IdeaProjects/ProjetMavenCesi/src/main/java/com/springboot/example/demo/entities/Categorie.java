package com.springboot.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @NotBlank
    @Column(name = "Nom")
    private String Name;
    public Categorie(){
        super();
    }
    public Categorie(Long id, String name) {
        super();
        this.id = id;
        this.Name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategorieName() {
        return Name;
    }
    public void setCategorieName(String name) {
        this.Name = name;
    }
}