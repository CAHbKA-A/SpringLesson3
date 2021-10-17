package com.example.springlesson3.controller;
import com.example.springlesson3.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddProductController {

    @GetMapping("/addProduct")
    public String greetingForm(Model model) {
        model.addAttribute("addProduct", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String greetingSubmit(@ModelAttribute Product addProduct, Model model) {
        model.addAttribute("addProduct", addProduct);
        return "product/productList";
    }

}