package com.backend.tes.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_groups")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
