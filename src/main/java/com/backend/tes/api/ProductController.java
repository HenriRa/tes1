package com.backend.tes.api;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public @ResponseBody List<ProductDto> getAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/products/{id}")
    public @ResponseBody ProductDto getProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }


//    @GetMapping("/products")
//    public @ResponseBody List<Product> getAllProducts(){
//        return productService.findAllProducts();
//    }
//
//    @GetMapping("/colors")
//    public @ResponseBody List<Color> getAllColors(){
//        return productService.findAllColors();
//    }
//
//    @GetMapping("/products?id={id}")
//    public @ResponseBody Optional<Product> getProductById(@PathVariable Long id){
//        return productService.findProductById(id);
//    }

}
