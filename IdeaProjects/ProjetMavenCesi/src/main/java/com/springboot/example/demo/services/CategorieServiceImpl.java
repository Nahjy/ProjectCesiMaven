package com.springboot.example.demo.services;

import com.springboot.example.demo.entities.Book;
import com.springboot.example.demo.entities.Categorie;
import com.springboot.example.demo.repositories.BookRepository;
import com.springboot.example.demo.repositories.CategorieRepository;
import com.springboot.example.demo.repositories.CategoryRepositoryInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    private CategoryRepositoryInMemory catrepository;

    @Autowired
    public CategorieServiceImpl(final CategorieRepository catrepo){
        this.catrepository = new CategoryRepositoryInMemory();
    }

    @Override
    public Categorie getCategorieById(Integer CatID) {
        return this.catrepository.getCategorieById(CatID);
    }


    public Categorie getCategorieById(Long CatID) {
        return this.catrepository.getCategorieById(CatID);
    }

    @Override
    public void addCategorie(Categorie cat) {
        this.catrepository.addCategorie(cat);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return this.catrepository.getAllCategories();
    }
}
