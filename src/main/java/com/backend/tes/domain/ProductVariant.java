package com.backend.tes.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="product_variants")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = false)
//    private Product product;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    private String imgUrl;
    private BigDecimal fullPrice;
    private BigDecimal monthlyPrice;
    private Boolean defaultVariant;

//    @OneToOne(mappedBy = "productVariant", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @OneToOne
//    @JoinColumn(name = "id", referencedColumnName = "variant_id")
//    private Stock stock;

    @OneToOne(mappedBy = "productVariant", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Stock stock;

//    @OneToMany(mappedBy = "productVariant")
//    private Set<OrderLine> orderLines;

}
