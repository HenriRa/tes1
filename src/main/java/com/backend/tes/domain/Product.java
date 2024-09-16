package com.backend.tes.domain;

import com.backend.tes.domain.query.ProductByFilter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name="products")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor

@SqlResultSetMapping(
        name = "ProductByFilterMapping",
        classes = {
                @ConstructorResult(
                        targetClass = ProductByFilter.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "brand", type = String.class),
                                @ColumnResult(name = "code", type = String.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "shortDescription", type = String.class),
                                @ColumnResult(name = "orderCount", type = BigInteger.class),
                                @ColumnResult(name = "color", type = String.class),
                                @ColumnResult(name = "imgUrl", type = String.class),
                                @ColumnResult(name = "monthlyPrice", type = BigDecimal.class),
                                @ColumnResult(name = "defaultVariant", type = Boolean.class),
                                @ColumnResult(name = "qtyInStock", type = BigInteger.class)
                        }
                )
        }
)

@NamedNativeQuery(
        name = "Product.findProductsByFilters",
        query = "SELECT p.id, b.name AS brand, p.code, p.name, p.short_description AS shortDescription, p.order_count AS orderCount, " +
                "c.name AS color, pv.img_url AS imgUrl, pv.monthly_price AS monthlyPrice, pv.default_variant AS defaultVariant, " +
                "s.qty_in_stock AS qtyInStock " +
                "FROM products p " +
                "JOIN brands b ON p.brand_id = b.id " +
                "JOIN product_variants pv ON p.id = pv.product_id " +
                "JOIN colors c ON pv.color_id = c.id " +
                "LEFT JOIN stock s ON pv.id = s.variant_id " +
                "WHERE (:brandNames IS NULL OR b.name IN (:brandNames)) " +
                "AND p.id = ANY " +
                "(SELECT pv1.product_id " +
                "FROM product_variants pv1 " +
                "JOIN colors c1 ON pv1.color_id = c1.id " +
                "LEFT JOIN stock s1 ON pv1.id = s1.variant_id " +
                "WHERE (:colorNames IS NULL OR c1.name IN (:colorNames)) " +
                "AND (:inStock IS NULL OR (s1.qty_in_stock > 0) = :inStock) " +
                "AND ((:priceIntervals IS NULL) OR EXISTS (" +
                " SELECT 1 FROM price_intervals pi " +
                " WHERE pv1.monthly_price BETWEEN pi.min_price AND pi.max_price " +
                " AND pi.name IN (:priceIntervals)))) ",
        resultSetMapping = "ProductByFilterMapping")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    private String code;
    private String name;
    private String shortDescription;
    private BigInteger orderCount;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductVariant> productVariants;

}
