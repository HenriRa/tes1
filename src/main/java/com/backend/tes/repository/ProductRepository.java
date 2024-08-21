package com.backend.tes.repository;

import com.backend.tes.domain.Brand;
import com.backend.tes.domain.Color;
import com.backend.tes.domain.Product;
import com.backend.tes.domain.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    List<Product> findByBrand(Brand brand);
//
//    List<Product> findByProductVariantsColor(Color color);

}
