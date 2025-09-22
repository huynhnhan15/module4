package com.codegym.blog.controller;

import com.codegym.blog.model.Category;
import com.codegym.blog.model.Post;
import com.codegym.blog.service.ICategoryService;
import com.codegym.blog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostService postService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String search,
                       Model model) {
        Page<Post> postPage = postService.search(search, PageRequest.of(page, 5, Sort.by("createdAt").descending()));
        model.addAttribute("postPage", postPage);
        model.addAttribute("search", search);
        return "posts/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryService.getAll());
        return "posts/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("categories", categoryService.getAll());
        return "posts/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        postService.delete(id);
        return "redirect:/posts";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "posts/view";
    }
}