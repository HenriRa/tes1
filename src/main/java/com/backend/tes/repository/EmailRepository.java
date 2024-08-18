package com.backend.tes.repository;

import com.backend.tes.domain.Email;
import com.backend.tes.domain.Order;
import com.backend.tes.domain.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findBySentTo(String sentTo);
    List<Email> findBySentFrom(String sentFrom);
    List<Email> findByStatus(String status);
    List<Email> findByCreatedOn(Timestamp createdOn);
    List<Email> findByModifiedOn(Timestamp modifiedOn);
    List<Email> findByTitle(String title);
    List<Email> findByMessage(String message);
    List<Email> findByOrderEvent(OrderEvent orderEvent);
    List<Email> findByOrderId(Order orderId);
}
