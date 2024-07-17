package com.codegym.email_setting.controllers;


import com.codegym.email_setting.models.Email;
import com.codegym.email_setting.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Repository
@RequestMapping("email")
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping("")
    public String emailList(Model model) {
        Email email = new Email();
        model.addAttribute("emailList", email);
        String[] language = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        model.addAttribute("language", language);
        int[] size = new int[]{5, 10, 15, 25, 50, 100};
        model.addAttribute("size", size);
        return "home";
    }

    @PostMapping("")
    public String sendEmail(@ModelAttribute Email email, Model model, RedirectAttributes redirect) {
        emailService.save(email);
        Email e = new Email();
        model.addAttribute("emailList", e);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/email";
    }

}
