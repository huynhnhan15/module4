package com.codegym.hom_thu_dien_tu.controller;


import com.codegym.hom_thu_dien_tu.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;

@Controller
public class EmailController {

    private Email setting = new Email();
    public EmailController() {
        setting.setLanguage("English");
        setting.setPageSize(25);
        setting.setSpamsFilter(false);
        setting.setSignature("Thor\nKing, Asgard");
    }

    @GetMapping("/")
    public String redirectToSettings() {
        return "redirect:/settings";
    }
    @GetMapping("/settings")
    public String showForm(Model model) {
        model.addAttribute("setting", setting);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        return "index";
    }
    @PatchMapping("/settings")
    public String updateSetting(@ModelAttribute("setting") Email email, Model model) {
        this.setting = email;
        model.addAttribute("setting", setting);
        return "result";
    }
}
