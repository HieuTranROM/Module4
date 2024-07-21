package com.codegym.blog.services;

import com.codegym.blog.models.Blog;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    List<Blog> findAllByName(String name);

//    Optional<Blog> findById(int id);

    void deleteById(int id);

    Blog findById(int id);
}
