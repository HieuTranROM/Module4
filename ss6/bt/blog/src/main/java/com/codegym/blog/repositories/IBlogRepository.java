package com.codegym.blog.repositories;

import com.codegym.blog.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findAllByNameContaining(@Param("name") String name);
}
