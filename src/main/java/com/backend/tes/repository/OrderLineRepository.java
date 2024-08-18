package com.backend.tes.repository;

import com.backend.tes.domain.Order;
import com.backend.tes.domain.OrderLine;
import com.backend.tes.domain.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findByOrder(Order order);

    List<OrderLine> findByProductVariant(ProductVariant productVariant);

    List<OrderLine> findByOrderAndProductVariant(Order order, ProductVariant productVariant);
}
