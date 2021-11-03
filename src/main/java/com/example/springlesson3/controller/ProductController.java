package com.example.springlesson3.controller;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryService;
import com.example.springlesson3.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final Validator validator;

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getProducts().getContent());
        model.addAttribute("currentPage", productService.getProducts().getPageable().getPageNumber() + 1);
        model.addAttribute("totalPage", productService.getProducts().getPageable().getPageSize());

        return "product/productList";

    }

    @GetMapping("/form")
    public String getProductForm(Model model,
                                 @RequestParam(required = false) Integer id,
                                 @ModelAttribute(value = "errors") String errors) {
        Product product = new Product();
        if (id != null) {//если продукт есть

            product = productService.getProductById(id);

        }
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "product/form";
    }


    @PostMapping()
    public RedirectView Submit(@ModelAttribute Product addProduct,
                               @RequestParam(required = false) MultipartFile img,
                               RedirectAttributes attributes) {
        System.out.println(addProduct);
        //проверили на ошибки
        Set<ConstraintViolation<Product>> validationSet = validator.validate(addProduct);

        if (!validationSet.isEmpty()) { //если есть хоть одна ошибка
            //набор ошибок
            String errors = validationSet.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("/n"));
            //передаем ошибки валидатора как атрибут ответа (на ридерект)
            attributes.addFlashAttribute("errors", errors);


            return new RedirectView("/product/form");
        }
        productService.addProductWithImg(addProduct, img);
        return new RedirectView("/product");//
    }


    @GetMapping("search")
    public String SearchProducts(Model model,
                                 @RequestParam(value = "minCost", required = false) Integer minCost,
                                 @RequestParam(value = "maxCost", required = false) Integer maxCost) {
        //  System.out.println(minCost + "  " + maxCost);
        Pageable pageable = PageRequest.of(0, 9, Sort.by(Sort.Direction.DESC, "title"));
        Page<Product> page = productService.findAllByCostLessThanEqualAndCostGreaterThanEqual(minCost, maxCost, pageable);
        System.out.println(page);
        model.addAttribute("products", page.getContent());
        model.addAttribute("currentPage", page.getPageable().getPageNumber() + 1);
        //тут какой то косяк Page 1 of 1 containing com.example.springlesson3.domain.Product instances а пишет 9
        model.addAttribute("totalPage", page.getPageable().getPageSize());
        return "product/productList";
    }


    @GetMapping("/product/{id}") //получаем форму
    public String findProductById(Model model, @PathVariable("id") int id) {
        model.addAttribute("products", productService.getProductById(id));
        model.addAttribute("currentPage", 1);
        model.addAttribute("totalPage", 1);
        return ("product/productList");
    }


    @GetMapping("/addProduct") //получаем форму
    public String addForm(Model model) {
        model.addAttribute("addProduct", new Product());
        return "product/addProduct";
    }


    @GetMapping("/deleteProduct/{id}") //получаем форму
    public String deleteProductQuery(Model model, @PathVariable("id") int id) {
        productService.deleteProduct(id);

        return ("/product/ok");

    }


}