package com.codegym.blog.service;

import com.codegym.blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    Page<Post> findAll(Pageable pageable);
    Page<Post> search(String title, Pageable pageable);
    Post findById(Long id);
    void save(Post post);
    void delete(Long id);
}