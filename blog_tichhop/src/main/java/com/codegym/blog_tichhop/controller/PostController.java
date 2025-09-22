package com.codegym.blog_tichhop.controller;

import com.codegym.blog_tichhop.model.Category;
import com.codegym.blog_tichhop.model.Post;
import com.codegym.blog_tichhop.service.ICategoryService;
import com.codegym.blog_tichhop.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostService postService;

    @Autowired
    private ICategoryService categoryService;

    // Danh sách tất cả bài viết hoặc tìm kiếm
    @GetMapping
    public String list(@RequestParam(defaultValue = "") String keyword,
                       @PageableDefault(size = 5, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {
        Page<Post> posts = keyword.isEmpty() ?
                postService.findAll(pageable) :
                postService.search(keyword, pageable);

        model.addAttribute("posts", posts);
        model.addAttribute("keyword", keyword);
        return "post/list";
    }

    // Lọc bài viết theo danh mục
    @GetMapping("/category/{id}")
    public String postsByCategory(@PathVariable Long id,
                                  @PageableDefault(size = 5, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
                                  Model model) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            Page<Post> posts = postService.findByCategory(category.get(), pageable);
            model.addAttribute("posts", posts);
            model.addAttribute("selectedCategory", category.get().getName());
            return "post/list";
        } else {
            return "redirect:/posts";
        }
    }

    // Hiển thị form tạo
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/create";
    }

    // Xử lý tạo
    @PostMapping("/create")
    public String create(@ModelAttribute Post post) {
        if (post.getTitle() == null || post.getTitle().trim().isEmpty()) {
            return "redirect:/posts/create?error=true";
        }
        postService.save(post);
        return "redirect:/posts";
    }

    // Hiển thị form cập nhật
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id).orElse(new Post()));
        return "post/edit";
    }

    // Xử lý cập nhật
    @PostMapping("/edit")
    public String update(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

    // Xóa bài viết
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/posts";
    }

    // Xem chi tiết
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "post/detail";
    }

    // Cung cấp danh sách danh mục cho tất cả view
    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

}
