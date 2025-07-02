package com.codegym.blog_tichhop.service;

import com.codegym.blog_tichhop.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    void save(Category category);
    void delete(Long id);
}

