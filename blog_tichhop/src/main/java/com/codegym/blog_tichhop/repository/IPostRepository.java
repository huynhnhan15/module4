package com.codegym.blog_tichhop.repository;

import com.codegym.blog_tichhop.model.Category;
import com.codegym.blog_tichhop.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByTitleContaining(String title, Pageable pageable);
    Page<Post> findAllByCategory(Category category, Pageable pageable);
}
