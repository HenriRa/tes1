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

    private Integer qtyInStock;

}
