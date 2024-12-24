package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo produitRepository;

    public List<Product> findAll() {
        return produitRepository.findAll();
    }

    public Product save(Product produit) {
        return produitRepository.save(produit);
    }
}
