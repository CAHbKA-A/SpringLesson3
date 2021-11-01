package com.example.springlesson3.service;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CustomerRepository;
import com.example.springlesson3.interfaces.ProductRepository;
import com.example.springlesson3.interfaces.ProductService;
import com.example.springlesson3.repository.specification.ProductSearchSpecification;
import com.example.springlesson3.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service

@RequiredArgsConstructor /*включает в конструтор только необходимые аргументы*/
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final CustomerRepository customerDAO;

    @Override
    public Page<Product> getProducts() {
        Pageable pageable = PageRequest.of(0, 9, Sort.by(Sort.Direction.DESC, "title"));
        return productRepository.findAll(pageable);

    }

    @Override
    public Page<Product> SearchProducts() {
        //постранично
        Pageable pageable = PageRequest.of(0, 9, Sort.by(Sort.Direction.DESC, "title"));
        ProductSearchSpecification productSearchSpecification = new ProductSearchSpecification(null);
        productRepository.findAll(productSearchSpecification);

        return productRepository.findAll(pageable);

    }


    @Override
    public void addProductWithImg(Product addProduct, MultipartFile img) {

        //сохроняем картинку


        if (img != null && !img.isEmpty()) {
            Path path = FileUtil.uploadProductImg(img);
            addProduct.setImgLink(path.toString());
        }
        productRepository.save(addProduct);

    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product editProduct(Product product) {
        Product productNew = productRepository.save(product);
        return product;
    }


    @Override
    public Page<Product> findAllByCostLessThanEqualAndCostGreaterThanEqual(Integer minCost, Integer maxCost, Pageable pageable) {

        return productRepository.findAllByCostLessThanEqualAndCostGreaterThanEqual(maxCost, minCost, pageable);
    }
}