package com.backend.tes.repository;

import com.backend.tes.domain.Order;
import com.backend.tes.domain.OrderLine;
import com.backend.tes.domain.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

//    List<OrderLine> findByOrderHeader(Order orderHeader);
//
//    List<OrderLine> findByProductVariant(ProductVariant productVariant);
//
//    List<OrderLine> findByOrderHeaderAndProductVariant(Order orderHeader, ProductVariant productVariant);
}
