package com.codegym.ss3_thymeleaf.controller;

import com.codegym.ss3_thymeleaf.model.Product;
import com.codegym.ss3_thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(ModelMap model) {
        model.addAttribute("products", productService.findAll());
        return "products/list";
    }

    @GetMapping("/create")
    public String showCreateForm(ModelMap model) {
        model.addAttribute("product", new Product());
        return "products/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Product added successfully!");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, ModelMap model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully!");
        return "redirect:/products";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, ModelMap model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "products/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, ModelMap model) {
        model.addAttribute("products", productService.searchByName(keyword));
        return "products/list";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.update(product.getId(), product);
        return "redirect:/products";
    }

}
