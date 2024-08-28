package com.backend.tes.service;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.api.mapper.ProductMapper;
import com.backend.tes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto findProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper.INSTANCE::productToProductDto)
                .orElse(null);
    }

    ////////////////////////////

//    public List<ProductDto> findProductByBrandName(String brandName) {
//        return productRepository.findByBrandName(brandName)
//                .stream()
//                .map(ProductMapper.INSTANCE::productToProductDto)
//                .collect(Collectors.toList());
//    }
//
//    public List<ProductDto> findProductByColorName(String colorName) {
//        return productRepository.findByProductVariantsColorName(colorName)
//                .stream()
//                .map(ProductMapper.INSTANCE::productToProductDto)
//                .collect(Collectors.toList());
//    }

    public List<ProductDto> findProductByBrandNameIn(List<String> brandNames) {
        return productRepository.findByBrandNameIn(brandNames)
                .stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findProductByColorNameIn(List<String> colorNames) {
        return productRepository.findByProductVariantsColorNameIn(colorNames)
                .stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findProductByBrandNameInAndColorNameIn(List<String> brandNames, List<String> colorNames) {
        return productRepository.findByBrandNameInAndProductVariantsColorNameIn(brandNames, colorNames)
                .stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }


    public List<ProductDto> findProductByStockQtyInStockGreaterThan(Integer qty) {
        return productRepository.findByProductVariantsStockQtyInStockGreaterThan(qty)
                .stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findProductByStockQtyInStockIsNull() {
        return productRepository.findByProductVariantsStockQtyInStockIsNull()
                .stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findProductByStockQtyInStockIsNotNull() {
        return productRepository.findByProductVariantsStockQtyInStockIsNotNull()
                .stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findProductByProductVariantsMonthlyPriceBetween(BigDecimal startPrice, BigDecimal endPrice) {
        return productRepository.findByProductVariantsMonthlyPriceBetween(startPrice, endPrice)
                .stream()
                .map(ProductMapper.INSTANCE::productToProductDto)
                .collect(Collectors.toList());
    }

}
