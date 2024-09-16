package com.backend.tes.api;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop")
public class ProductController {

    private final ProductService productService;

//    @GetMapping("/products")
//    public @ResponseBody List<ProductDto> getAllProducts(){
//        return productService.findAllProducts();
//    }
//
//    @GetMapping("/products/{id}")
//    public @ResponseBody ProductDto getProductById(@PathVariable Long id){
//        return productService.findProductById(id);
//    }


//    @GetMapping("/products?id={id}")
//    public @ResponseBody ProductDto getProductById
//            (@RequestParam(value = "id") Long id){
//        return productService.findProductById(id);
//    }

}
