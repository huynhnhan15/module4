package com.codegym.songvalidate.controller;

import com.codegym.songvalidate.model.Song;
import com.codegym.songvalidate.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Song song,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        songService.save(song);
        return "redirect:/songs";
    }
}
