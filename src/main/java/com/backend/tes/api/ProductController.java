package com.backend.tes.api;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

//    @GetMapping("/products/brand/{brandName}")
//    public @ResponseBody List<ProductDto> getProductByBrandName(@PathVariable String brandName){
//        return productService.findProductByBrandName(brandName);
//    }
//
//    @GetMapping("/products/color/{colorName}")
//    public @ResponseBody List<ProductDto> getProductByColorName(@PathVariable String colorName){
//        return productService.findProductByColorName(colorName);
//    }

//    @GetMapping("/products/brand/{brandName}/color/{colorName}/price")
//    public @ResponseBody List<ProductDto> getProductByBrandNameAndColorNameAndPrice
//            (@PathVariable String brandName, @PathVariable String colorName, @RequestParam BigDecimal startPrice, @RequestParam BigDecimal endPrice){
//        return productService.findProductByBrandNameAndColorNameAndPrice(brandName, colorName, startPrice, endPrice);
//    }

    @GetMapping("/products/brand/{brandNames}/color/{colorNames}")
    public @ResponseBody List<ProductDto> getProductByBrandNameAndColorName
            (@PathVariable List<String> brandNames, @PathVariable List<String> colorNames){
        return productService.findProductByBrandNameInAndColorNameIn(brandNames, colorNames);
    }




    @GetMapping("/products/brands")
    public @ResponseBody List<ProductDto> getProductByBrandNameIn
            (@RequestParam List<String> brandNames){
        return productService.findProductByBrandNameIn(brandNames);
    }

    @GetMapping("/products/colors")
    public @ResponseBody List<ProductDto> getProductByColorNameIn
            (@RequestParam List<String> colorNames){
        return productService.findProductByColorNameIn(colorNames);
    }

    @GetMapping("/products/stock/greater-than/{qty}")
    public @ResponseBody List<ProductDto> getProductByStockQtyInStockGreaterThan
            (@PathVariable Integer qty){
        return productService.findProductByStockQtyInStockGreaterThan(qty);
    }

    @GetMapping("/products/stock/null")
    public @ResponseBody List<ProductDto> getProductByStockQtyInStockIsNull(){
        return productService.findProductByStockQtyInStockIsNull();
    }

    @GetMapping("/products/stock/not-null")
    public @ResponseBody List<ProductDto> getProductByStockQtyInStockIsNotNull(){
        return productService.findProductByStockQtyInStockIsNotNull();
    }

    @GetMapping("/products/price")
    public @ResponseBody List<ProductDto> getProductByMonthlyPriceBetween
            (@RequestParam BigDecimal startPrice, @RequestParam BigDecimal endPrice){
        return productService.findProductByProductVariantsMonthlyPriceBetween(startPrice, endPrice);
    }


//    @GetMapping("/products?id={id}")
//    public @ResponseBody ProductDto getProductById
//            (@RequestParam(value = "id") Long id){
//        return productService.findProductById(id);
//    }

}
