package com.codegym.blog.services;

import com.codegym.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Page<Blog> findAllByName(String name, Pageable pageable);

    void deleteById(int id);

    Blog findById(int id);

    Optional<Blog> findByIdOptional(int id);

    List<Blog> findByCategoryId(Long id);

}
