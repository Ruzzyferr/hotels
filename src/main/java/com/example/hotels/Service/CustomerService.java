package com.example.hotels.Service;

import com.example.hotels.DTO.CustomerDTO;
import com.example.hotels.DTO.CustomerDeleteRequestDTO;
import com.example.hotels.DTO.CustomerSaveRequestDTO;
import com.example.hotels.Entity.Customer;
import com.example.hotels.Mappers.CustomerMapper;
import com.example.hotels.repository.CustomerRepository;
import com.example.hotels.util.Encryptor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService {

    Encryptor encryptor = Encryptor.getInstance();
    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }



    public CustomerDTO save(CustomerSaveRequestDTO dto){
       Customer customer = customerMapper.toCustomerFromSaveRequestDto(dto);
        customer.setTc(encryptor.generateSecurePassword(customer.getTc()));
        customer.setPassportNo(encryptor.generateSecurePassword(customer.getPassportNo()));
       customer = customerRepository.save(customer);

      CustomerDTO dto2 = customerMapper.toDto(customer);

      dto2.setTc(encryptor.gerDecryptedPassword(dto2.getTc()));
      dto2.setPassportNo(encryptor.gerDecryptedPassword(dto2.getPassportNo()));

       return dto2;
    }

    public CustomerDTO delete(CustomerDeleteRequestDTO dto){
        Customer customer = customerMapper.toCustomerFromDeleteRequestDto(dto);
        customer = customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

}
