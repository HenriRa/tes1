package com.backend.tes.domain;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor
public class Email {
    private Long id;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
    private String sentFrom;
    private String sentTo;
    private String title;
    private String message;
    private String status;

    private OrderEvent orderEvent;
    private Long orderId;
}
