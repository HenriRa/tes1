package com.backend.tes.service;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.api.mapper.ProductMapper;
import com.backend.tes.domain.Product;
import com.backend.tes.domain.enums.SortStrings;
import com.backend.tes.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto findProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productToProductDto)
                .orElse(null);
    }

    public Page<ProductDto> findAllProducts(List<String> productGroup,
                                            List<String> brands,
                                            List<String> colors,
                                            Boolean inStock,
                                            List<String> priceIntervals,
                                            String sortBy) {

        Pageable pageable;
        if(sortBy != null) {
            Sort.Order sortOrder = determineSortOrder(SortStrings.valueOf(sortBy.toUpperCase()));
            pageable = PageRequest.of(0, 50, Sort.by(sortOrder));
        }
        else {
            pageable = PageRequest.of(0, 50);
        }

        Page<Product> productPage = productRepository.findProductsByFilters(
                productGroup,
                brands,
                colors,
                inStock,
                priceIntervals,
                pageable);

        List<ProductDto> productDtoList = productPage.stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());

        return new PageImpl<>(productDtoList, pageable, productPage.getTotalElements());
    }

    // Create
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    private Sort.Order determineSortOrder(SortStrings sortBy) {
        String[] parts = sortBy.toString().split("_");
        return switch (parts[1]) {
            case "ASC" -> Sort.Order.asc(sortBy.getValue());
            case "DESC" -> Sort.Order.desc(sortBy.getValue());
            default -> throw new IllegalArgumentException("Invalid sortBy value: " + sortBy);
        };
    }


}
