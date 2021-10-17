package com.example.springlesson3.controller;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String addSubmit(@ModelAttribute Product addProduct, Model model) {


        System.out.println(addProduct);
        productService.addProduct(addProduct);
        System.out.println(productService.getProducts());// изза зашглушки показывает старое. вообще при работе с бд, должен добавить
        model.addAttribute("addProduct");
        return "product/productList";
    }

}