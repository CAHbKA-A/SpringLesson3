package com.example.springlesson3.service;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.domain.ProductSearch;
import com.example.springlesson3.domain.View.convertor.ProductMapper;
import com.example.springlesson3.domain.View.dto.ProductDtoDefault;
import com.example.springlesson3.interfaces.ProductRepository;
import com.example.springlesson3.interfaces.ProductService;
import com.example.springlesson3.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.nio.file.Path;
import java.util.List;

@Service

@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

 //   private final ProductConvertor productConvertor;


    @Override
    public List<ProductDtoDefault> getProducts() {






        List<ProductDtoDefault> products = findAll();


        return products;
    }


    @Override
    public ProductDtoDefault addProductWithImg(ProductDtoDefault addProduct, MultipartFile img) {

        //сохроняем картинку


        if (img != null && !img.isEmpty()) {
            Path path = FileUtil.uploadProductImg(img);
            addProduct.setImgLink(path.toString());
        }
        return save(addProduct);

    }
    public List<ProductDtoDefault> findAll() {
        //выдергиваем из БД,конвертируем,
        return ProductMapper.MAPPER.fromProductList(productRepository.findAll());
        //    return ProductMapper.MAPPER.fromProductList(productRepository.findAllItemsWithCategories());
    }

    public ProductDtoDefault save(ProductDtoDefault itemDto) {
        //преобразуем в продукт
        Product product = ProductMapper.MAPPER.toProduct(itemDto);
        //сохроняем
        product = productRepository.save(product);
        return ProductMapper.MAPPER.fromProduct(product);
    }
    @Override
    @Transactional
    public ProductDtoDefault findByIdDto(long id) {
        Product entity = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return ProductDtoDefault.builder()
                .id(entity.getId())
                .cost(entity.getCost())
                .title(entity.getTitle())
                .build();
    }

    @Override
    public Page<Product> findAllBySearchCondition(ProductSearch searchCondition){
        Pageable pageRequest = PageRequest.of(
                searchCondition.getPageNum(),
                searchCondition.getPagesSize(),
                Sort.by(searchCondition.getSortDirection(), searchCondition.getSortField()));

        return productRepository.findAll(pageRequest);
    }

}