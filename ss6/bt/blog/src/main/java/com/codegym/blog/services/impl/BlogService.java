package com.codegym.blog.services.impl;

import com.codegym.blog.models.Blog;
import com.codegym.blog.repositories.IBlogRepository;
import com.codegym.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAllByName(String name) {
        return blogRepository.findAllByNameContaining(name);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }


}
