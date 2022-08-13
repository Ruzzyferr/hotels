package com.example.hotels.mapper;


import com.example.hotels.dto.*;
import com.example.hotels.entity.Customer;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Named("toEntity")
    Customer toEntity (CustomerDTO dto);

    @Named("toDto")
    CustomerDTO toDto (Customer entity);

    Customer toCustomerFromSaveRequestDto (CustomerSaveRequestDTO dto);

    @IterableMapping(qualifiedByName = "toDto")
    List<CustomerDTO> toDtoList (List<Customer> entityList);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Customer> toEntityList (List<CustomerDTO> dtoList);


}
