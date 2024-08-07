package com.backend.tes.domain;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.MODULE)
@NoArgsConstructor
public class User {
    private Long id;
    private Timestamp createdOn;
    private Timestamp modifiedOn;
    private String username;
    private String password;
    private String email;
    private String role;

}
