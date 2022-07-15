package com.alex.demopractice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AuditFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long customerId;

    @Column(name = "customer_name", nullable = false)
    @Schema(example = "Niyonsaba Alex", required = true)
    private String customerName;

    @Column(name = "customer_address", nullable = false)
    @Schema(example = "Makerere Kikoni", required = true)
    private String customerAddress;

    @Column(name = "customer_phone_number", nullable = false, unique = true)
    @Schema(example = "0787946565", required = true)
    private String customerPhoneNumber;

    @Column(name = "customer_email", nullable = false, unique = true)
    @Schema(example = "alexnewzniyo@gmail.com", required = true)
    private String customerEmail;
}
