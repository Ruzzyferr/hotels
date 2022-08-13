package com.example.hotels.controller;

import com.example.hotels.dto.CustomerDTO;
import com.example.hotels.dto.CustomerSaveRequestDTO;
import com.example.hotels.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        return new ResponseEntity<>(customerService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<CustomerDTO>> listAllCustomers() {
        return new ResponseEntity<>(customerService.listAllCustomers(), HttpStatus.OK);
    }

}
