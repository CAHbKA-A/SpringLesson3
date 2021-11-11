package com.example.springlesson3.service;

import com.example.springlesson3.controller.rest.ProductConvertor;
import com.example.springlesson3.domain.Product;
import com.example.springlesson3.domain.ProductSearch;
import com.example.springlesson3.domain.View.convertor.ProductMapper;
import com.example.springlesson3.domain.View.dto.ProductDtoDefault;
import com.example.springlesson3.interfaces.ProductRepository;
import com.example.springlesson3.interfaces.ProductService;
import com.example.springlesson3.repository.specification.ProductSearchSpecification;
import com.example.springlesson3.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@Service

@RequiredArgsConstructor /*включает в конструтор только необходимые аргументы*/
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConvertor productConvertor;





    @Override
    public List<ProductDtoDefault> getProducts() {
        List<ProductDtoDefault> products = productConvertor.findAll();


        return products;
    }



    @Override
    public ProductDtoDefault addProductWithImg(ProductDtoDefault addProduct, MultipartFile img) {

        //сохроняем картинку


        if (img != null && !img.isEmpty()) {
            Path path = FileUtil.uploadProductImg(img);
            addProduct.setImgLink(path.toString());
        }
      return   productConvertor.save(addProduct);

    }












    @Override
    public Page<Product> getProductsByConditional(ProductSearch conditional) {
        //постранично
        Pageable pageable = PageRequest.of(conditional.getPageIndex(), conditional.getSize());
        ProductSearchSpecification productSearchSpecification = new ProductSearchSpecification(conditional);
        productRepository.findAll(productSearchSpecification);

        return productRepository.findAll(productSearchSpecification, pageable);

    }






    @Override
    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product editProduct(Product product) {
        Product productNew = productRepository.save(product);
        return product;
    }


    @Override
    public Page<Product> findAllByCostLessThanEqualAndCostGreaterThanEqual(Integer minCost, Integer maxCost, Pageable pageable) {
        // проверка кривых рук
        if (maxCost == null) {//если мин макс перепутано меняем местамии
            maxCost = Integer.MAX_VALUE;

        }
        if (minCost == null) {//если мин макс перепутано меняем местамии
            minCost = 0;

        }
        if (minCost > maxCost) {//если мин макс перепутано , меняем местамии
            maxCost = minCost + maxCost;
            minCost = maxCost - minCost;
            maxCost = maxCost - minCost;
        }


        return productRepository.findAllByCostLessThanEqualAndCostGreaterThanEqual(maxCost, minCost, pageable);
    }

    @Override
    public List<Product> findAllByCategories_Alias(String alias) {
        return productRepository.findAllByCategories_PathUrl(alias);
    }

//    @Override
//    public List<Product> findAllByCategories(int id) {
//       return productRepository.findAllByCategoriesEquals(id);
//    }
}