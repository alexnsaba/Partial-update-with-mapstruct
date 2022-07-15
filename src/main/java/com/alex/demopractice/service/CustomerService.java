package com.alex.demopractice.service;

import com.alex.demopractice.config.ConfigurationConstants;
import com.alex.demopractice.config.OperationResult;
import com.alex.demopractice.datamapper.CustomerDto;
import com.alex.demopractice.datamapper.CustomerMapper;
import com.alex.demopractice.entity.Customer;
import com.alex.demopractice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private OperationResult operationResult;

    public OperationResult findAllCustomers() {
        List<Customer> retrievedCustomers = customerRepository.findAll();
        operationResult = new OperationResult(ConfigurationConstants.SUCCESS_STATUS, null, retrievedCustomers);
        return operationResult;
    }

    public OperationResult findCustomerById(long customerId) {
        Customer retrievedCustomer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException(ConfigurationConstants.NO_RECORD_FOUND_MESSAGE));
        operationResult = new OperationResult(ConfigurationConstants.SUCCESS_STATUS, null, retrievedCustomer);
        return operationResult;
    }

    public OperationResult createCustomer(Customer customer){
        customer.setWhenCreated(LocalDateTime.now());
        Customer createdCustomer = customerRepository.save(customer);
        operationResult = new OperationResult(ConfigurationConstants.SUCCESS_STATUS, ConfigurationConstants.OPERATION_SUCCESS_MESSAGE, null);
        return operationResult;
    }

    public OperationResult updateCustomer(CustomerDto customerDto){
        Customer retrievedCustomer = customerRepository.findById(customerDto.getCustomerId()).orElseThrow(() -> new RuntimeException(ConfigurationConstants.NO_RECORD_FOUND_MESSAGE));

        CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

        Customer customer = mapper.getCustomerEntityFromDto(customerDto,retrievedCustomer);

        customerRepository.save(customer);

        operationResult = new OperationResult(ConfigurationConstants.SUCCESS_STATUS,ConfigurationConstants.OPERATION_SUCCESS_MESSAGE, null);

        return operationResult;
    }
}
