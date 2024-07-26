package com.codegym.blog.controllers;

import com.codegym.blog.models.Blog;
import com.codegym.blog.models.Category;
import com.codegym.blog.services.IBlogService;
import com.codegym.blog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}/blogs")
    public ResponseEntity<?> getBlogsByCategoryId(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Blog> blogs = blogService.findByCategoryId(id);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
