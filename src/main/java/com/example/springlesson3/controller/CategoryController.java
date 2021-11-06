package com.example.springlesson3.controller;

import com.example.springlesson3.domain.Category;
import com.example.springlesson3.interfaces.CategoryService;
import com.example.springlesson3.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    private final Validator validator;




    @GetMapping("/form")
    public String getCategoryForm(@RequestParam(required = false) Long id, Model model,
                                  @ModelAttribute(value = "errors") String violations) {
        Category category = new Category();
        if (id != null) {
            category = categoryService.findById(id);
            System.out.println("____"+category);
        }

        model.addAttribute("category", category);
        model.addAttribute("violations", violations);
        model.addAttribute("categories", categoryService.findAll());

        return "category/form";
    }


    @PostMapping
    public RedirectView saveCategory(Category category, RedirectAttributes attributes) {
        Set<ConstraintViolation<Category>> violationResult = validator.validate(category);
        if (!violationResult.isEmpty()) {
            String violations = violationResult.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));

            attributes.addFlashAttribute("violations", violations);

            return new RedirectView("/category/form");
        }
        System.out.println("save "+category);
        categoryService.save(category);

        return new RedirectView("/product");
    }

//    @GetMapping("/cat")
//    public String findProductByCategoryAlias(Model model,
//
//                                             @RequestParam(value = "category", required = false) Integer cat) {
//        System.out.println("!  "+ categoryService.findProductsByByCategoriesEquals(cat));
//
//        model.addAttribute("products", categoryService.findProductsByByCategoriesEquals(cat));
//        model.addAttribute("currentPage", 1);
//        model.addAttribute("totalPage", 1);
//        return ("product/productList");
//    }

}
