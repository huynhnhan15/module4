package com.codegym.blog_tichhop.service;

import com.codegym.blog_tichhop.model.Category;
import com.codegym.blog_tichhop.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repo;

    public List<Category> findAll() { return repo.findAll(); }

    public Optional<Category> findById(Long id) { return repo.findById(id); }

    public void save(Category c) { repo.save(c); }

    public void delete(Long id) { repo.deleteById(id); }
}