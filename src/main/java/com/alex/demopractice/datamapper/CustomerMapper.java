package com.alex.demopractice.datamapper;

import com.alex.demopractice.entity.Customer;
import org.mapstruct.*;

@Mapper(componentModel = "spring")

public interface CustomerMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    Customer getCustomerEntityFromDto(CustomerDto customerDto, @MappingTarget Customer customer);
}
