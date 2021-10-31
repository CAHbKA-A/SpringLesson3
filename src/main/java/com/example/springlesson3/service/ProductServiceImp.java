package com.example.springlesson3.service;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CustomerRepository;
import com.example.springlesson3.interfaces.ProductRepository;
import com.example.springlesson3.interfaces.ProductService;
import com.example.springlesson3.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@Service
//@ToString
@RequiredArgsConstructor /*включает в конструтор только необходимые аргументы*/
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final CustomerRepository customerDAO;

    @Override
    public List<Product> getProducts() {
        //  System.out.println(customerDAO.getOrdersByCustomerId(2));
        // customerDAO.getOrderProductsByCustomerId(1);
        // System.out.println(customerDAO.get(1));
        return productRepository.findAll();
    }

//    @Override
//    public void addProduct(Product product) {
//
//        productRepository.addNew(product);
//    }

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
}