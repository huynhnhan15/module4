package com.codegym.blog_tichhop.controller;


import com.codegym.blog_tichhop.model.Category;
import com.codegym.blog_tichhop.model.Post;
import com.codegym.blog_tichhop.service.ICategoryService;
import com.codegym.blog_tichhop.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IPostService postService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        List<Post> latestPosts = postService.findAll(
                PageRequest.of(0, 5, Sort.by("createdAt").descending())
        ).getContent();

        model.addAttribute("latestPosts", latestPosts);
        model.addAttribute("categories", categoryService.findAll());
        return "home";
    }
}
