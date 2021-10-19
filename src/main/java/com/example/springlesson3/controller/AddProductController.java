package com.example.springlesson3.controller;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller

public class AddProductController {

    private ProductService productService;

    public AddProductController(ProductService productService) {
        this.productService = productService;
    }




    @GetMapping("/addProduct") //получаем форму
    public String addForm(Model model) {
        model.addAttribute("addProduct", new Product());
        return "product/addProduct";
    }

    @PostMapping("/addProduct")
    public RedirectView addSubmit(@ModelAttribute Product addProduct, @RequestParam(required = false) MultipartFile img) {
        productService.addProductWithImg(addProduct, img);

        return new RedirectView("/product");// перенаправляем на гет
    }

}