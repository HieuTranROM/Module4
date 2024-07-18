package com.codegym.product_management.services;

import com.codegym.product_management.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(int id);

    List<Product> findByName(String name);
}
