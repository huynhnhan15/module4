package com.codegym.ung_dung_muon_sach.controller;


import com.codegym.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }

    @PostMapping("/borrow/{id}")
    public String borrow(@PathVariable Long id, RedirectAttributes ra) {
        String code = bookService.borrowBook(id);
        ra.addFlashAttribute("message", "Mã mượn sách của bạn: " + code);
        return "redirect:/books";
    }

    @GetMapping("/return")
    public String showReturnForm() {
        return "return";
    }

    @PostMapping("/return")
    public String doReturn(@RequestParam String code, RedirectAttributes ra) {
        bookService.returnBook(code);
        ra.addFlashAttribute("message", "Trả sách thành công!");
        return "redirect:/books";
    }
}
