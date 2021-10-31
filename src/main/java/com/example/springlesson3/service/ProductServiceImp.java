package com.example.springlesson3.service;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CustomerDAO;
import com.example.springlesson3.interfaces.ProductDAO;
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

    private final ProductDAO productDAO;
    private final CustomerDAO customerDAO;

    @Override
    public List<Product> getProducts() {
        //  System.out.println(customerDAO.getOrdersByCustomerId(2));
        // customerDAO.getOrderProductsByCustomerId(1);
        // System.out.println(customerDAO.get(1));
        return productDAO.getAll();
    }

    @Override
    public void addProduct(Product product) {

        productDAO.addNew(product);
    }

    @Override
    public void addProductWithImg(Product addProduct, MultipartFile img) {

        //сохроняем картинку
//todo проверить размер или делать утилиту ужималки


        if (img != null && !img.isEmpty()) {
            Path path = FileUtil.uploadProductImg(img);
            addProduct.setImgLink(path.toString());
        }
        productDAO.addNew(addProduct);

    }

    @Override
    public Product getProductById(int id) {
        return productDAO.get(id);
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

    @Override
    public Product editProduct(Product product) {
        Product productNew = productDAO.saveOrUpdate(product);
        return product;
    }
}