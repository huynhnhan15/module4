package com.codegym.blog_tichhop.controller.api;

import com.codegym.blog_tichhop.model.Category;
import com.codegym.blog_tichhop.model.Post;
import com.codegym.blog_tichhop.service.ICategoryService;
import com.codegym.blog_tichhop.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {
    @Autowired
    private IPostService postService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public Page<Post> getAll(Pageable pageable) {
        return postService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        return postService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Page<Post>> getByCategory(@PathVariable Long id, Pageable pageable) {
        Optional<Category> cat = categoryService.findById(id);
        return cat.map(c -> ResponseEntity.ok(postService.findByCategory(c, pageable)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public Page<Post> search(@RequestParam String keyword, Pageable pageable) {
        return postService.search(keyword, pageable);
    }
}
