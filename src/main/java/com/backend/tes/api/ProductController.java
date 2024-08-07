package com.backend.tes.api;

import com.backend.tes.domain.Product;
import com.backend.tes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/shop")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public @ResponseBody Iterable<Product> getAllProducts(){
        return productService.findAllProducts();
    }

}
