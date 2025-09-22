package com.codegym.blog.service;
import com.codegym.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
    Category findById(Long id);
    void save(Category category);
    void delete(Long id);
}