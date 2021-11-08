package com.example.springlesson3.controller.rest;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryService;
import com.example.springlesson3.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor

public class ProductResController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts().getContent();
    }


    @GetMapping("/{id}")
    public Product getStudentById(@PathVariable Long id) {
        //  System.out.println(productService.getProductById(id).getTitle());
        return productService.getProductById(id);
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product,
                              @RequestPart(required = false) MultipartFile image) {
        System.out.println(product);
        productService.addProductWithImg(product, image);

    }
//    @RequestMapping(method = {POST, PUT}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String saveProduct(@RequestPart Product product,
//                              @RequestPart(required = false) MultipartFile image) {
//        System.out.println(product);
//        productService.addProductWithImg(product, image);
//        return "ok";
//    }

}
