package com.backend.tes.api;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.domain.Product;
import com.backend.tes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/shop")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
     public @ResponseBody Iterable<Product> getAllProducts(){
        return productService.findAllProducts();
    }
//    public @ResponseBody List<ProductDto> getAllProducts(){
//        return productService.findAllProducts().stream()
//                .map(ProductService::productToDto)
//                .collect(Collectors.toList());
//    }

    @GetMapping("/products?id={id}")
    public @ResponseBody Product getProductById(@PathVariable Long id){
        return productService.findProductById(id).orElse(null);
    }



}
