package com.backend.tes.service;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.domain.Product;
import com.backend.tes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }

//    public static ProductDto productToDto(Product product) {
//        return new ProductDto(
//                product.getId(),
//                String.valueOf(product.getBrandId()), // Assuming brandId maps to brand name
//                String.valueOf(product.getColorId()), // Assuming colorId maps to color name
//                product.getSku(),
//                product.getTitle(),
//                product.getDescription(),
//                product.getImg_url(),
//                null, // Assuming price is not available in Product entity
//                null  // Assuming qtyInStock is not available in Product entity
//        );
//    }

}
