package com.backend.tes.repository;

import com.backend.tes.domain.Address;
import com.backend.tes.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCustomer(Customer customer);
}
