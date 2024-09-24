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

    @Autowired
    private final ProductService productService;

    @GetMapping("/products?productGroup={productGroup}&brands={brands}&colors={colors}&inStock={inStock}&priceIntervals={priceIntervals}")
    public final @ResponseBody List<ProductDto> getAllProducts
            (@RequestParam(value = "productGroup") String productGroup,
             @RequestParam(value = "brands", required = false) List<String> brands,
             @RequestParam(value = "colors", required = false) List<String> colors,
             @RequestParam(value = "inStock", required = false) Boolean inStock,
             @RequestParam(value = "priceIntervals", required = false) List<String> priceIntervals){
        return productService.findAllProducts(productGroup, brands, colors, inStock, priceIntervals);
    }

//    @GetMapping("/products/{id}")
//    public @ResponseBody ProductDto getProductById(@PathVariable Long id){
//        return productService.findProductById(id);
//    }


    @GetMapping("/products?id={id}")
    public final @ResponseBody ProductDto getProductById
            (@RequestParam(value = "id") Long id){
        return productService.findProductById(id);
    }

}
