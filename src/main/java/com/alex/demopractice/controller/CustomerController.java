package com.alex.demopractice.controller;

import com.alex.demopractice.config.OperationResult;
import com.alex.demopractice.datamapper.CustomerDto;
import com.alex.demopractice.entity.Customer;
import com.alex.demopractice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<OperationResult> findAllCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<OperationResult> findCustomerById(@PathVariable("customerId") long customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findCustomerById(customerId));
    }

    @PostMapping
    public ResponseEntity<OperationResult> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.createCustomer(customer));
    }

    @PatchMapping
    public ResponseEntity<OperationResult> updateCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customerDto));
    }
}
