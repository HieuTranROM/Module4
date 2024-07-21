package com.codegym.product_management.controllers;


import com.codegym.product_management.models.Product;
import com.codegym.product_management.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Repository
@RequestMapping(value= "product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String getProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/list";

    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String newProduct(@ModelAttribute("product") Product product,
                             BindingResult bindingResult,
                             RedirectAttributes redirect
    ) {
        if(bindingResult.hasFieldErrors()) {
            return "product/create";
        }
        productService.save(product);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/product/update";
    }


    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("price") double price,
                                @RequestParam("description") String description,
                                @RequestParam("produce") String produce,
                                RedirectAttributes redirect) {
        Product product = new Product(id, name, price, description, produce);
        productService.update(product);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/product";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirect) {
        productService.delete(id);
        redirect.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/product";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("name") String name, Model model) {
        List<Product> products = productService.findByName(name);
        model.addAttribute("products", products);
        return "product/search";
    }

    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product/detail";
        }
        model.addAttribute("message", "Sản phẩm không tồn tại");
        return "redirect:/product";
    }

}
