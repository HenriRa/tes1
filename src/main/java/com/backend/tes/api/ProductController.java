package com.backend.tes.api;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/shop")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public final @ResponseBody Page<ProductDto> getAllProducts
            (@RequestParam(value = "productGroup", required = false) List<String> productGroup,
             @RequestParam(value = "brands", required = false) List<String> brands,
             @RequestParam(value = "colors", required = false) List<String> colors,
             @RequestParam(value = "inStock", required = false) Boolean inStock,
             @RequestParam(value = "priceIntervals", required = false) List<String> priceIntervals,
             @RequestParam(value = "sort") String sortBy) {

        return productService.findAllProducts(productGroup, brands, colors, inStock, priceIntervals, sortBy);
    }

    @GetMapping("/products/{id}")
    public @ResponseBody ProductDto getProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ProductDto addProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @PutMapping("/products/{id}/update")
    public @ResponseBody ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id){
        return productService.updateProduct(productDto, id);
    }
}
