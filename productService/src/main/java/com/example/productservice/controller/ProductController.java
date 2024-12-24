package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produits")
public class ProductController {
    @Autowired
    private ProductService produitService;

    @GetMapping
    public List<Product> getAllProduits() {
        return produitService.findAll();
    }

    @PostMapping
    public Product addProduit(@RequestBody Product produit) {
        return produitService.save(produit);
    }
}
