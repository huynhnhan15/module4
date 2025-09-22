package com.codegym.blog_tichhop.repository;

import com.codegym.blog_tichhop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
