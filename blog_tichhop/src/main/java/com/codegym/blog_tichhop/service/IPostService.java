package com.codegym.blog_tichhop.service;

import com.codegym.blog_tichhop.model.Category;
import com.codegym.blog_tichhop.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPostService {
    Page<Post> findAll(Pageable pageable);
    Optional<Post> findById(Long id);
    void save(Post post);
    void delete(Long id);
    Page<Post> search(String title, Pageable pageable);
    Page<Post> findByCategory(Category category, Pageable pageable);
}
