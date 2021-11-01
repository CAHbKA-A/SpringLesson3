package com.example.springlesson3.controller;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductService productService;


    @GetMapping("/search")
    public String SearchProducts(Model model,
                                 @RequestParam(value = "minCost", required = false) Integer minCost,
                                 @RequestParam(value = "maxCost", required = false) Integer maxCost) {
        //  System.out.println(minCost + "  " + maxCost);
        Pageable pageable = PageRequest.of(0, 9, Sort.by(Sort.Direction.DESC, "title"));
        Page<Product> page = productService.findAllByCostLessThanEqualAndCostGreaterThanEqual(minCost, maxCost, pageable);
        System.out.println(page);
        model.addAttribute("products", page.getContent());
        model.addAttribute("currentPage", page.getPageable().getPageNumber() + 1);
        //тут какой то косяк Page 1 of 1 containing com.example.springlesson3.domain.Product instances а пишет 9
        model.addAttribute("totalPage", page.getPageable().getPageSize());
        return "product/productList";
    }

    // не смог через кондишн/ попробую чуть позже
// @PostMapping("/product/**") //
//    public String productSearch(Model model,@ModelAttribute Product editProduct,
//                                      @RequestParam(required = false) int minCost,
//                                      @RequestParam(required = false) int maxCost) {
//
//         System.out.println(maxCost+"  "+minCost);
//        model.addAttribute("products", getProductByCondition(@RequestBody ProductSearchCondition searchCondition);
//   //     model.addAttribute("products", productService.getProductById(id));
//        return ("product/productList");
//    }

    @GetMapping("/product")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getProducts().getContent());
        model.addAttribute("currentPage", productService.getProducts().getPageable().getPageNumber() + 1);
        model.addAttribute("totalPage", productService.getProducts().getPageable().getPageSize());

        return "product/productList";

    }


    @GetMapping("/product/{id}") //получаем форму
    public String findProductById(Model model, @PathVariable("id") int id) {
        model.addAttribute("products", productService.getProductById(id));
        model.addAttribute("currentPage", 1);
        model.addAttribute("totalPage", 1);
        return ("product/productList");
    }


    @GetMapping("/addProduct") //получаем форму
    public String addForm(Model model) {
        model.addAttribute("addProduct", new Product());
        return "product/addProduct";
    }

    @PostMapping("/addProduct")
    public RedirectView addSubmit(@ModelAttribute Product addProduct, @RequestParam(required = false) MultipartFile
            img) {
        //   System.out.println(addProduct);
        productService.addProductWithImg(addProduct, img);

        return new RedirectView("/product");// перенаправляем на гет
    }

    @GetMapping("/editProduct/{id}") //получаем форму
    public String editForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("editProduct", productService.getProductById(id));
        return "product/editProduct";
    }


    @PostMapping("/editProduct/**") //проверяем и едактируем
    public RedirectView editSubmit(@ModelAttribute Product
                                           editProduct, @RequestParam(required = false) MultipartFile img) {
        // System.out.println(editProduct);
        productService.editProduct(editProduct);
        return new RedirectView("/product");// перенаправляем на гет
    }


    @GetMapping("/deleteProduct/{id}") //получаем форму
    public String deleteProductQuery(Model model, @PathVariable("id") int id) {
        productService.deleteProduct(id);

        return ("/product/ok");

    }


}