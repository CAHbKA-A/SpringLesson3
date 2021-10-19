package com.example.springlesson3.controller;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getProducts());

        return "product/productList";
    }

//вот так не получается. все в одном классе.
//    @GetMapping("/addProduct") //получаем форму
//    public String addForm(Model model) {
//        model.addAttribute("addProduct", new Product());
//        return "product/addProduct";
//    }
//
//    @PostMapping("/addProduct")
//    public RedirectView addSubmit(@ModelAttribute Product addProduct, @RequestParam(required = false) MultipartFile img) {
//        productService.addProductWithImg(addProduct, img);
//
//        return new RedirectView("/product");// перенаправляем на гет
//    }
//

}