package com.codegym.blog.controllers;

import com.codegym.blog.models.Blog;
import com.codegym.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

//Đánh dấu đây là 1 controller (1 bean)
//Annotation Controller
//Bài tập về nhà: phân biệt @Component, @Controller, @Service, @Repository (đều sử dụng để tạo bean)
@Controller
@RequestMapping(value = "blog")
public class BlogController {

//    Cơ chế DI (Dependence injection): Tiêm phụ thuộc để giảm sự phụ thuộc
//    DI: Field/Interface
//    DI: Setter
//    DI: Constructor

    //    Scope và vòng đời của Bean
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String displayAllStudents(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
//        ModelAndView modelAndView = new ModelAndView("student/list");
//        modelAndView.addObject("students", studentService.findAll());
//        modelAndView.addObject("student", new Student());
//        return new ModelAndView("student/list", "students", studentService.findAll());
//        Model, ModelMap và ModelAndView
        return "blog/list";
    }

    //    @RequestMapping (value = "/create", method = RequestMethod.GET)
    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String newBlog(@ModelAttribute("blog") Blog blog,
                          BindingResult bindingResult,
                          RedirectAttributes redirect
    ) {
        if (bindingResult.hasFieldErrors()) {
            return "blog/create";
        }
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/blog";
    }
    

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/update";
    }

    @PostMapping("/update/{id}")
    public String save(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String searchBlog(@RequestParam("nameBlog") String nameBlog, Model model) {
        List<Blog> blogs = blogService.findAllByName(nameBlog);
        model.addAttribute("blogs", blogs);
        model.addAttribute("nameBlog", nameBlog);
        return "blog/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id, RedirectAttributes redirect) {
        blogService.deleteById(id);
        redirect.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/blog";

    }

    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            model.addAttribute("blog", blog);
            return "blog/detail";
        }
        model.addAttribute("message", "Blog bạn xem không tồn tại");
        return "redirect:/blog";
    }

}