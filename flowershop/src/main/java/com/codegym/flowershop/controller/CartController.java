package com.codegym.flowershop.controller;

import com.codegym.flowershop.model.Product;
import com.codegym.flowershop.service.IProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private IProductService productService;

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {
        Product product = productService.findById(id);
        if (product != null) {
            List<Product> cart = (List<Product>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
            }
            cart.add(product);
            session.setAttribute("cart", cart);
        }
        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        model.addAttribute("cart", cart);
        return "cart/view";
    }
}