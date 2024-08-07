package com.backend.tes.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    @Getter
    private Timestamp createdOn;
    @Getter
    private Timestamp modifiedOn;
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String email;

    public Customer(){
    }

    public Customer(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer [id=" + customer_id + ", name=" + firstName + " " + lastName + ", email=" + email + "]";
    }

    //@JsonInclude(JsonInclude.Include.NON_NULL) USing Jackson
    //add user connection
    //private User user;
}
