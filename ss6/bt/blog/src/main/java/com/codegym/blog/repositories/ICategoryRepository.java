package com.codegym.blog.repositories;

import com.codegym.blog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
