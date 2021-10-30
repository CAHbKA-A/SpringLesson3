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
    //    System.out.println(customerDAO.getOrders(1));
        return productDAO.getAll();
        //   return ProductDao.findAll();
    }

    @Override
    public void addProduct(Product product) {

        productDAO.addNew(product);
        //   ProductDao.addProduct(product);
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
        //  ProductDao.addProduct(addProduct);


    }

    @Override
    public Product getProductById(int id) {
        return productDAO.get(id);
        // return ProductDao.findById(id);

    }

    @Override
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
        //  ProductDao.deleteById(id);
    }

    @Override
    public Product editProduct(Product product) {
        Product productNew = productDAO.saveOrUpdate(product);
        return product;
    }
}