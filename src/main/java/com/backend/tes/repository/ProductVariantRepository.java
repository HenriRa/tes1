package com.backend.tes.repository;

import com.backend.tes.domain.Color;
import com.backend.tes.domain.Product;
import com.backend.tes.domain.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
    List<ProductVariant> findByProduct(Product product);

    List<ProductVariant> findByColor(Color color);

    List<ProductVariant> findByProductAndColor(Product product, Color color);

    List<ProductVariant> findByProductAndColorAndMonthlyPriceBetween
            (Product product, Color color, BigDecimal startPrice, BigDecimal endPrice);

    List<ProductVariant> findByProductAndMonthlyPriceBetween
            (Product product, BigDecimal startPrice, BigDecimal endPrice);


    List<ProductVariant> findByProductAndColorAndFullPriceBetween
            (Product product, Color color, BigDecimal startPrice, BigDecimal endPrice);

    List<ProductVariant> findByProductAndFullPriceBetween(Product product, BigDecimal startPrice, BigDecimal endPrice);

    List<ProductVariant> findByDefaultVariantTrue();

    List<ProductVariant> findByStockQuantityGreaterThan(int quantity);

    List<ProductVariant> findByStockQuantityEquals(int quantity);

    List<ProductVariant> findByProductAndMonthlyPriceLessThanEqual(Product product, BigDecimal maxMonthlyPrice);

}
