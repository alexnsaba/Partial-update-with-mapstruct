package com.alex.demopractice.datamapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CustomerDto {
    private long customerId;

    private String customerName;

    private String customerAddress;

    private String customerPhoneNumber;

    private String customerEmail;
}
