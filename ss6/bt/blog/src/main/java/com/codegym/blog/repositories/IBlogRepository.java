package com.codegym.blog.repositories;

import com.codegym.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
    List<Blog> findByCategoryId(Long categoryId);
    Page<Blog> findByCategoryId(Long categoryId, Pageable pageable);  // Add this method
}
