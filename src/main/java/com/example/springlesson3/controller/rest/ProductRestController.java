package com.example.springlesson3.controller.rest;

import com.example.springlesson3.domain.View.dto.ProductDtoDefault;
import com.example.springlesson3.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor

public class ProductRestController {
    private final ProductService productService;


    @GetMapping
    public List<ProductDtoDefault> getProducts() {
        return productService.getProducts();
    }


    @RequestMapping(method = {POST, PUT}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProductDtoDefault saveProduct(@RequestPart ProductDtoDefault product,
                                         @RequestPart(required = false) MultipartFile image) {

        return productService.addProductWithImg(product, image);
    }


}
