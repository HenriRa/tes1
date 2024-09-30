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

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    private String imgUrl;
    private BigDecimal monthlyPrice;
    private Boolean defaultVariant;

    @OneToMany
    @JoinColumn(name = "variant_id")
    private Set<Stock> stock;

}
