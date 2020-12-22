package org.sid.billingservice.entities;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
}
