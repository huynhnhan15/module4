package com.codegym.validate_form.controller;

import com.codegym.validate_form.model.User;
import com.codegym.validate_form.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
public class FormController {

    @Autowired
    private IUserService userService;

    // Truy cập "/" sẽ tự động chuyển đến trang đăng ký
    @GetMapping("/")
    public String redirectToRegister() {
        return "redirect:/register";
    }

    // Hiển thị form đăng ký
    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Tên file HTML là register.html
    }

    // Xử lý submit form
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        userService.save(user); // Lưu vào DB
        model.addAttribute("user", user); // Truyền dữ liệu sang result.html
        return "result";
    }
}
