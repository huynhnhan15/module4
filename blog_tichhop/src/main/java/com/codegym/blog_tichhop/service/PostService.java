package com.codegym.blog_tichhop.service;

import com.codegym.blog_tichhop.model.Category;
import com.codegym.blog_tichhop.model.Post;
import com.codegym.blog_tichhop.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository repo;

    public Page<Post> findAll(Pageable pageable) { return repo.findAll(pageable); }

    public Optional<Post> findById(Long id) { return repo.findById(id); }

    public void save(Post post) { repo.save(post); }

    public void delete(Long id) { repo.deleteById(id); }

    public Page<Post> search(String title, Pageable pageable) {
        return repo.findByTitleContaining(title, pageable);
    }

    public Page<Post> findByCategory(Category category, Pageable pageable) {
        return repo.findAllByCategory(category, pageable);
    }
}
