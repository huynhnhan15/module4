package com.codegym.flowershop.controller;

import com.codegym.flowershop.service.IProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String listProducts(Model model, HttpSession session) {
        var list = productService.findAll();
        List<?> cart = (List<?>) session.getAttribute("cart");
        int cartSize = (cart != null) ? cart.size() : 0;

        model.addAttribute("products", list);
        model.addAttribute("cartSize", cartSize);
        return "product/list";
    }

    @GetMapping("/{id}")
    public String productDetail(@PathVariable Long id, Model model, HttpSession session) {
        model.addAttribute("product", productService.findById(id));
        List<?> cart = (List<?>) session.getAttribute("cart");
        int cartSize = (cart != null) ? cart.size() : 0;
        model.addAttribute("cartSize", cartSize);
        return "product/detail";
    }
}