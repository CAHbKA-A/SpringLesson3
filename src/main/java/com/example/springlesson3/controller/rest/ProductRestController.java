package com.example.springlesson3.controller.rest;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.domain.ProductSearch;
import com.example.springlesson3.domain.View.dto.ProductDtoDefault;
import com.example.springlesson3.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public ProductDtoDefault getProductById(@PathVariable(name = "id") Long id) {
        return productService.findByIdDto(id);
    }

    @PostMapping()
    public Page<Product> getProductByCondition(@RequestBody ProductSearch searchCondition){
        return productService.findAllBySearchCondition(searchCondition);
    }


}
