package com.backend.tes.repository;

import com.backend.tes.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query(value = "SELECT p.id AS productID, b.name AS brand, p.code AS productCode, p.name AS productName, " +
//            "p.short_description AS shortDescription, p.order_count AS orderCount, " +
//            "c.name AS color, pv.img_url AS imgUrl, pv.monthly_price AS monthlyPrice, " +
//            "pv.default_variant AS defaultVariant, s.qty_in_stock AS qtyInStock " +
//            "FROM products p " +
//            "JOIN brands b ON p.brand_id = b.id " +
//            "JOIN product_variants pv ON p.id = pv.product_id " +
//            "JOIN colors c ON pv.color_id = c.id " +
//            "LEFT JOIN stock s ON pv.id = s.variant_id " +
//            "WHERE (:brandNames IS NULL OR b.name IN (:brandNames)) " +
//            "AND p.id = ANY " +
//                    "(SELECT pv1.product_id " +
//                    "FROM product_variants pv1 " +
//                    "JOIN colors c1 ON pv1.color_id = c1.id " +
//                    "LEFT JOIN stock s1 ON pv1.id = s1.variant_id " +
//                    "WHERE (:colorNames IS NULL OR c1.name IN (:colorNames)) " +
//                    "AND (:inStock IS NULL OR (s1.qty_in_stock > 0) = :inStock) " +
//                    "AND ((:priceIntervals IS NULL) OR EXISTS (" +
//                    " SELECT 1 FROM price_intervals pi " +
//                    " WHERE pv1.monthly_price BETWEEN pi.min_price AND pi.max_price " +
//                    " AND pi.name IN (:priceIntervals)))) " +
////            "ORDER BY p.order_count DESC ", nativeQuery = true)
//            "ORDER BY (CASE " +
//            " WHEN :sortBy = 'price_asc' THEN pv.monthly_price " +
//            " WHEN :sortBy = 'price_desc' THEN -pv.monthly_price " +
//            " ELSE -p.order_count " +
//            " END) ",
//            nativeQuery = true)

//    @EntityGraph(attributePaths = {"productVariants"})
//    @Query(
//            "SELECT p FROM Product p " +
//                    "JOIN p.productVariants pv " +
//                    "WHERE (:brandNames IS NULL OR p.brand.name IN :brandNames) " +
//
////                    "AND (:colorNames IS NULL OR pv.color.name IN :colorNames) " +
////                    "AND (:inStock IS NULL " +
////                    "  OR (:inStock = TRUE AND pv.stock.qtyInStock > 0) " +
////                    "  OR (:inStock = FALSE AND pv.stock.qtyInStock = 0)) " +
////                    "AND ((:priceIntervals IS NULL) OR EXISTS (" +
////                    " SELECT 1 FROM PriceInterval pi " +
////                    " WHERE pv.monthlyPrice BETWEEN pi.minPrice AND pi.maxPrice " +
////                    " AND pi.name IN :priceIntervals)) "
//
//                    "AND p.id IN " +
//                    "(SELECT pv1.product.id " +
//                    "FROM p.productVariants pv1 " +
////                    "JOIN pv1.color c1 " +
////                    "LEFT JOIN pv1.stock s1 " +
//                    "WHERE (:colorNames IS NULL OR pv1.color.name IN :colorNames) " +
//                    "AND (:inStock IS NULL " +
//                    "  OR (:inStock = TRUE AND pv1.stock.qtyInStock > 0) " +
//                    "  OR (:inStock = FALSE AND pv1.stock.qtyInStock = 0)) " +
//                    "AND ((:priceIntervals IS NULL) OR EXISTS (" +
//                    " SELECT 1 FROM PriceInterval pi " +
//                    " WHERE pv1.monthlyPrice BETWEEN pi.minPrice AND pi.maxPrice " +
//                    " AND pi.name IN :priceIntervals))) "
//
////                    "ORDER BY (CASE " +
////                    " WHEN :sortBy = 'price_asc' THEN pv.monthlyPrice " +
////                    " WHEN :sortBy = 'price_desc' THEN -pv.monthlyPrice " +
////                    " ELSE -p.orderCount " +
////                    " END)"
//
//    )

//    @EntityGraph(attributePaths = {"productVariants"})
    @Query("SELECT p FROM Product p " +
            "LEFT OUTER JOIN p.productVariants pv " +
            "WHERE (:productGroup IS NULL OR p.productGroup.name = :productGroup) " +
            "AND (:brandNames IS NULL OR p.brand.name IN :brandNames) " +
            "AND (:colorNames IS NULL OR pv.color.name IN :colorNames) " +
            "AND (:inStock IS NULL OR (:inStock = TRUE AND pv.stock.qtyInStock > 0) OR (:inStock = FALSE AND pv.stock.qtyInStock = 0)) " +
            "AND ((:priceIntervals IS NULL) OR EXISTS (" +
            " SELECT 1 FROM PriceInterval pi " +
            " WHERE pv.monthlyPrice BETWEEN pi.minPrice AND pi.maxPrice " +
            " AND pi.name IN :priceIntervals))")
    List<Product> findProductsByFilters(
            @Param("productGroup") String productGroup,
            @Param("brandNames") List<String> brandNames,
            @Param("colorNames") List<String> colorNames,
            @Param("inStock") Boolean inStock,
            @Param("priceIntervals") List<String> priceIntervals
    );


    Product findProductById(Long id);

    // Used for testing examples
//    List<Product> findByBrandNameIn(Collection<String> brandNames);
//
//    List<Product> findByProductVariantsColorNameIn(Collection<String> colorNames);


}
