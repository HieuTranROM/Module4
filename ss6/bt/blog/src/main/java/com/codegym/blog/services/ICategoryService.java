package com.codegym.blog.services;

import com.codegym.blog.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();

    List<Category> findAll();

    Category findById(Long id);
}
