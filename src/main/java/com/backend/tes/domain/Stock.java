package com.backend.tes.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="stock")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "variant_id", referencedColumnName = "id")
    private ProductVariant productVariant;



    private Integer qtyInStock;

}
