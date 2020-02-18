package com.springboot.example.demo.controllers;

import com.springboot.example.demo.entities.Book;
import com.springboot.example.demo.entities.Categorie;
import com.springboot.example.demo.services.BookService;
import com.springboot.example.demo.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CategorieController {

    private CategorieService catService;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;
    @Value("${intro.message}")
    private String introMessage;

    @Autowired
    public CategorieController(final CategorieService catsvc){
        this.catService = catsvc;
    }

    @GetMapping(value = "/categorie/{CategorieID}")
    @ResponseBody
    Categorie getCategorieById(@PathVariable final Integer CategorieID) {
        System.out.println("polop");
        System.out.println("categorie : " + this.catService.getCategorieById(CategorieID).getCategorieName());
        return this.catService.getCategorieById(CategorieID);
    }

    @GetMapping(value = "/categorie")
    @ResponseBody
    List<Categorie> getAllCategories() {
        return this.catService.getAllCategories();
    }

    @PostMapping(value = "/categorie")
    @ResponseStatus(HttpStatus.OK)
    void addCategorie(@RequestBody Categorie cat){
        this.catService.addCategorie(cat);
    }

}

//ID, Nom