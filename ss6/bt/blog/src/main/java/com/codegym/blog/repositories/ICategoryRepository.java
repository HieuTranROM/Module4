package com.codegym.blog.repositories;

import com.codegym.blog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
