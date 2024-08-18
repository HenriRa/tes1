package com.backend.tes.domain;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor
public class OrderEvent {
    private Long id;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
    private String name;
    private String logDescription;

    private Order orderId;
}
