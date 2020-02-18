package com.springboot.example.demo.repositories;

import com.springboot.example.demo.entities.Categorie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryInMemory implements CategorieRepository {
    private ArrayList<Categorie> category;

    public CategoryRepositoryInMemory() {
        this.category = new ArrayList<>();
        this.category.add(new Categorie((long) 1, "Test"));
    }

    public Categorie getCategorieById(Long catId) {
        for(Categorie b : this.category){
            if(b.getId() == catId) return b;
        }

        return null;
    }

    @Override
    public Categorie getCategorieById(Integer catId) {
        for(Categorie b : this.category){
            if(b.getId() == catId.longValue()) return b;
        }
        return null;
    }

    public void addCategorie(Categorie cat) {
        this.category.add(cat);
    }

    public List<Categorie> getAllCategories() {
        return this.category;
    }
}
