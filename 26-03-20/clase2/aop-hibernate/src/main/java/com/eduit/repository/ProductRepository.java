package com.eduit.repository;

import com.eduit.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);
}
