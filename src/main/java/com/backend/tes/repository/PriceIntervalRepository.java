package com.backend.tes.repository;

import com.backend.tes.domain.PriceInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceIntervalRepository extends JpaRepository<PriceInterval, Long> {

    PriceInterval findByName(String name);

}
