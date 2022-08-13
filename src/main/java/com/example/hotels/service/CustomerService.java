package com.example.hotels.service;

import com.example.hotels.dto.CustomerDTO;
import com.example.hotels.dto.CustomerSaveRequestDTO;
import com.example.hotels.entity.Customer;
import com.example.hotels.mapper.CustomerMapper;
import com.example.hotels.repository.CustomerRepository;
import com.example.hotels.util.Encryptor;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public boolean delete(int id){
        Customer customer = customerRepository.findByIdAndActiveTrue(id).orElseThrow(() -> new RuntimeException("Active customer could not found with id: " + id));
        customer.setActive(false);
        customerRepository.save(customer);
        return true;
    }

    public List<CustomerDTO> listAllCustomers() {
        return customerMapper.toDtoList(customerRepository.findAllByActiveTrue());
    }

}
