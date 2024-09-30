package com.backend.tes.repository;

import com.backend.tes.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p " +
            "LEFT JOIN p.productVariants pv " +
            "WHERE (:productGroup IS NULL OR p.productGroup.name = :productGroup) " +
            "AND (:brandNames IS NULL OR p.brand.name IN :brandNames) " +
            "AND (:colorNames IS NULL OR pv.color.name IN :colorNames) " +
            "AND (:inStock IS NULL " +
            "     OR (:inStock = TRUE AND ELEMENT(pv.stock).qtyInStock > 0) " +
            "     OR (:inStock = FALSE AND ELEMENT(pv.stock).qtyInStock = 0)) " +
            "AND ((:priceIntervals IS NULL) OR EXISTS (" +
            "      SELECT 1 FROM PriceInterval pi " +
            "      WHERE pv.monthlyPrice BETWEEN pi.minPrice AND pi.maxPrice " +
            "      AND pi.name IN :priceIntervals)) ")

    Page<Product> findProductsByFilters(
            @Param("productGroup") String productGroup,
            @Param("brandNames") List<String> brandNames,
            @Param("colorNames") List<String> colorNames,
            @Param("inStock") Boolean inStock,
            @Param("priceIntervals") List<String> priceIntervals,
            Pageable pageable
    );

}
