package com.example.springlesson3.service;

import com.example.springlesson3.domain.Product;
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

    @Override
    public List<Product> getProducts() {
        return productRepository.getAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addNew(product);
    }

    @Override
    public void addProductWithImg(Product addProduct, MultipartFile img) {

        //сохроняем картинку
//todo проверить размер или делать утилиту ужималки


        if (img != null && !img.isEmpty()) {
            //   System.out.println(img);
            Path path = FileUtil.uploadProductImg(img);
            addProduct.setImgLink(path.toString());

        }
        System.out.println("как будто записал в БД " + addProduct);
        //Обращение к бд - добавляем продукт c  сылкой на картинку

    }
}