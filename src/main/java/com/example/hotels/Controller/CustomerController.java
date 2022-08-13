package com.example.hotels.Controller;

import com.example.hotels.DTO.CustomerDTO;
import com.example.hotels.DTO.CustomerDeleteRequestDTO;
import com.example.hotels.DTO.CustomerSaveRequestDTO;
import com.example.hotels.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerSaveRequestDTO dto){
        CustomerDTO customerDTO = customerService.save(dto);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<CustomerDTO> delete(@RequestBody CustomerDeleteRequestDTO dto){
        CustomerDTO customerDTO = customerService.delete(dto);
        return new ResponseEntity<>(customerDTO, HttpStatus.ACCEPTED);
    }

}
