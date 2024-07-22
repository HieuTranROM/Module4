package com.codegym.blog.repositories;

import com.codegym.blog.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findAllByNameContaining(String name);
}
