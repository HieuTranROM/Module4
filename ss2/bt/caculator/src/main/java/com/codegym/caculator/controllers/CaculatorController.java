package com.codegym.caculator.controllers;

import com.codegym.caculator.services.impl.CaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("caculator")
public class CaculatorController {

    @Autowired
    private CaculatorService caculatorService;

    @GetMapping("")
    public String caculator() {
        return "/list";
    }

    @PostMapping
    public String result(@RequestParam(value = "first", required = false) double firstNumber,
                         @RequestParam(value = "second", required = false) double secondNumber,
                         @RequestParam("item") String item,
                         Model model) {
        try {
            double result = caculatorService.calculate(firstNumber,secondNumber,item);
            model.addAttribute("result", result);
            return "/list";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/calculator";
    }


}
