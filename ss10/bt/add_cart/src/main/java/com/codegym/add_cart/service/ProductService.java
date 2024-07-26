package com.codegym.add_cart.service;

import com.codegym.add_cart.model.Product;
import com.codegym.add_cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public boolean create(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }
}

