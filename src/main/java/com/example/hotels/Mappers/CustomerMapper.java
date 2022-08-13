package com.example.hotels.Mappers;


import com.example.hotels.DTO.*;
import com.example.hotels.Entity.Customer;
import com.example.hotels.Entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Named("toEntity")
    Customer toEntity (CustomerDTO dto);

    @Named("toDto")
    CustomerDTO toDto (Customer entity);

    Customer toCustomerFromSaveRequestDto (CustomerSaveRequestDTO dto);

    Customer toCustomerFromDeleteRequestDto (CustomerDeleteRequestDTO dto);

    @IterableMapping(qualifiedByName = "toDto")
    List<CustomerDTO> toDtoList (List<Customer> entityList);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Customer> toEntityList (List<CustomerDTO> dtoList);


}
