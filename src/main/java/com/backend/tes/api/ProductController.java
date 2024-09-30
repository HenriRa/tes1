package com.backend.tes.api;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.service.ProductService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public final @ResponseBody Page<ProductDto> getAllProducts
            (@RequestParam(value = "productGroup", required = false) String productGroup,
             @RequestParam(value = "brands", required = false) List<String> brands,
             @RequestParam(value = "colors", required = false) List<String> colors,
             @RequestParam(value = "inStock", required = false) Boolean inStock,
             @RequestParam(value = "priceIntervals", required = false) List<String> priceIntervals,
             Pageable pageable) {
//             @RequestParam(value = "sortBy", required = false) String sortBy){

        return productService.findAllProducts(productGroup, brands, colors, inStock, priceIntervals, pageable);
    }

    @GetMapping("/products/{id}")
    public @ResponseBody ProductDto getProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }




}
