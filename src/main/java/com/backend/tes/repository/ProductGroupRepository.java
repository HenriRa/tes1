package com.backend.tes.repository;

import com.backend.tes.domain.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {

    ProductGroup findByName(String name);

}
