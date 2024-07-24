package com.codegym.validate_thong_tin_bai_hat.controllers;

import com.codegym.validate_thong_tin_bai_hat.dto.SongDTO;
import com.codegym.validate_thong_tin_bai_hat.models.Song;
import com.codegym.validate_thong_tin_bai_hat.services.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String displaySong(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "song/index";
    }

    @GetMapping("/create")
    public String showAddForm(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "song/create";
    }

    @PostMapping("/create")
    public String addSong(@Validated @ModelAttribute("songDTO") SongDTO songDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.save(song);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/song";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
            model.addAttribute("error", "Bài hát không tồn tại");
            return "error";
        }
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song, songDTO);
        model.addAttribute("songDTO", songDTO);
        model.addAttribute("id", id);
        return "song/update";
    }

    @PostMapping("/update/{id}")
    public String updateSong(@PathVariable("id") Long id, @Valid @ModelAttribute("songDTO") SongDTO songDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "song/update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        song.setId(id);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Cập nhật bài hát thành công");
        return "redirect:/song";
    }

}