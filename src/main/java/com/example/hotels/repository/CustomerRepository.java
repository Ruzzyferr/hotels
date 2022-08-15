package com.example.hotels.repository;

import com.example.hotels.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByActiveTrue();

    Optional<Customer> findByIdAndActiveTrue(int id);

    boolean existsByIdAndActiveTrue(int id);
}
