package com.codegym.validate_form_dang_ky.controllers;


import com.codegym.validate_form_dang_ky.dto.UserDTO;
import com.codegym.validate_form_dang_ky.models.User;
import com.codegym.validate_form_dang_ky.services.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("")
    public String displayUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/user/index";
    }

    @GetMapping("/result")
    public String createUser(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "user/result";
    }

    @PostMapping("/result")
    public String createUser(@Validated @ModelAttribute("userDTO") UserDTO userDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "user/result";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.save(user);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/user";
    }
}
