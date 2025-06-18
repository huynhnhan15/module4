package com.codegym.blog.service;

import com.codegym.blog.model.Post;
import com.codegym.blog.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> search(String title, Pageable pageable) {
        return postRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setCreatedAt(java.time.LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}