package com.backend.tes.repository;

import com.backend.tes.domain.Customer;
import com.backend.tes.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

//    List<Order> findByCustomer(Customer customer);

}
