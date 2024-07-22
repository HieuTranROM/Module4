package com.codegym.blog.repositories;

import com.codegym.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
}
