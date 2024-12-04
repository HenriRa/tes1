package com.backend.tes.service;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.api.mapper.ProductMapper;
import com.backend.tes.domain.Product;
import com.backend.tes.domain.enums.SortStrings;
import com.backend.tes.exception.RecordNotFoundException;
import com.backend.tes.repository.BrandRepository;
import com.backend.tes.repository.ProductGroupRepository;
import com.backend.tes.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final BrandRepository brandRepository;
    private final ProductGroupRepository productGroupRepository;

    public ProductDto findProductById(Long id) {
        return productRepository
                .findById(id)
                .map(productMapper::productToProductDto)
                .orElseThrow(() -> new RecordNotFoundException("Product with id: " + id + " not found."));
    }

    public Page<ProductDto> findAllProducts(List<String> productGroup,
                                            List<String> brands,
                                            List<String> colors,
                                            Boolean inStock,
                                            List<String> priceIntervals,
                                            String sortBy) {

        if(sortBy == null) sortBy = SortStrings.DEFAULT_SORT;

        Sort.Order sortOrder = determineSortOrder(SortStrings.valueOf(sortBy.toUpperCase()));
        Pageable pageable = PageRequest.of(0, 5, Sort.by(sortOrder));

        Page<Product> productPage = productRepository.findProductsByFilters(
                convertToLowercase(productGroup),
                convertToLowercase(brands),
                convertToLowercase(colors),
                inStock,
                priceIntervals,
                pageable);

        List<ProductDto> productDtoList = productPage.stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());

        return new PageImpl<>(productDtoList, pageable, productPage.getTotalElements());
    }


    public ProductDto createProduct(ProductDto productDto) {
        Product newProduct = productRepository.save(productMapper.productDtoToProduct(productDto));
        Product savedProduct = getProductOrThrowException(newProduct.getId());
        return productMapper.productToProductDto(savedProduct);
    }

    public ProductDto updateProduct(ProductDto productDto, long id) {
        Product product = getProductOrThrowException(id);
        product.setProductGroup(productGroupRepository.findByName(productDto.productGroup()));
        product.setBrand(brandRepository.findByName(productDto.brand()));
        product.setCode(productDto.code());
        product.setName(productDto.name());
        product.setShortDescription(productDto.shortDescription());
        product.setOrderCount(productDto.orderCount());

        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductDto(savedProduct);
    }


    // Add delete methods for variants and stock, if there are no orders placed!
// Or use smth like a flag for active/inactive product, which determines whether to show the product to end user or not!
//    public void deleteProduct(long id) {
//        productRepository.deleteById(id);
//    }




    private Product getProductOrThrowException(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Product with id: " + id + " not found."));
    }

    private Sort.Order determineSortOrder(SortStrings sortBy) {
        String[] parts = sortBy.toString().split("_");
        return switch (parts[1]) {
            case "ASC" -> Sort.Order.asc(sortBy.getValue());
            case "DESC" -> Sort.Order.desc(sortBy.getValue());
            default -> throw new IllegalArgumentException("Invalid sortBy value: " + sortBy);
        };
    }

    private List<String> convertToLowercase(List<String> list) {
        if (list == null)   return null;
        return list.stream()
                .filter(Objects::nonNull)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }


}
