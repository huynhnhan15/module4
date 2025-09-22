package com.codegym.hien_thi_danh_sach.controller;


import com.codegym.hien_thi_danh_sach.model.Sandwich;
import com.codegym.hien_thi_danh_sach.repository.ISandwichRepository;
import com.codegym.hien_thi_danh_sach.service.ISandwichSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class SandwichController {

    @Autowired
    private ISandwichSevice sandwichSevice;

    @GetMapping({"/", "/index"})
    public String showSandwichList(Model model) {
        List<Sandwich> sandwichList = sandwichSevice.findAll();
        model.addAttribute("sandwichList", sandwichList);
        return "/index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "sandwich", required = false) String[] sandwich, Model model) {
        model.addAttribute("sandwichs", sandwich);
        return "/result"; // ánh xạ tới result.jsp
    }
}

