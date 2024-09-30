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

    public ProductDto findProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productToProductDto)
                .orElse(null);
    }

    public Page<ProductDto> findAllProducts(String productGroup,
                                            List<String> brands,
                                            List<String> colors,
                                            Boolean inStock,
                                            List<String> priceIntervals,
//                                            String sortBy
                                            Pageable pageable) {

        // pageable parse string to field and sortOrder
        // Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.asc("pv.monthlyPrice")));
//        Sort.Order sortOrder = determineSortOrder(SortStrings.valueOf(sortBy.toUpperCase()));
//        Pageable pageable = PageRequest.of(0, 10, Sort.by(sortOrder));

        // Solution 1
//        Sort sort = pageable.getSort();
//        Pageable pageableRepo = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
//
//        return productRepository.findProductsByFilters(
//                        productGroup,
//                        brands,
//                        colors,
//                        inStock,
//                        priceIntervals,
//                        pageableRepo)
//                .stream()
//                .map(productMapper::productToProductDto)
//                .collect(Collectors.toList());

        // Solution 2
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
        return switch (sortBy) {
            case PRICE_ASC -> Sort.Order.asc("pv.monthlyPrice");
            case PRICE_DESC -> Sort.Order.desc("pv.monthlyPrice");
            case POPULAR_DESC -> Sort.Order.desc("orderCount");
            default -> throw new IllegalArgumentException("Invalid sortBy value: " + sortBy);
        };
    }


}
