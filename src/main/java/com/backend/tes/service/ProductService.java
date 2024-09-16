package com.backend.tes.service;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.api.mapper.ProductMapper;
import com.backend.tes.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

//    public Page<Object[]> searchProducts(
//            List<String> brands,
//            List<String> colors,
//            Boolean inStock,
//            List<String> priceIntervals,
//            String sortBy,
//            int page,
//            int size) {
//
//        Pageable pageable = PageRequest.of(page, size);
//        return productRepository.findProductsByFilters(brands, colors, inStock, priceIntervals, sortBy, pageable);
//
//    }



//    public Page<ProductDto> findAllProducts() {
//        return productRepository.findAll(Pageable).stream()
//                .map(productMapper::productToProductDto)
//                .collect(Collectors.toList());
//    }

//    public ProductDto findProductById(Long id) {
//        return productRepository.findById(id)
//                .map(productMapper::productToProductDto)
//                .orElse(null);
//    }


}
