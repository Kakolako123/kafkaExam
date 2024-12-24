package com.example.productservice.GrapheQL;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProduitQuery implements GraphQLQueryResolver {
    @Autowired
    private ProductService produitService;

    public List<Product> getProduits() {
        return produitService.findAll();
    }
}
