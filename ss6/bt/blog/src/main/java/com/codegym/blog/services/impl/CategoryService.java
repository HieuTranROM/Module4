package com.codegym.blog.services.impl;

import com.codegym.blog.models.Category;
import com.codegym.blog.repositories.ICategoryRepository;
import com.codegym.blog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
