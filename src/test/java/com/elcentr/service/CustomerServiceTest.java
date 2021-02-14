package com.elcentr.service;

import com.elcentr.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerServiceTest {

    @Test
    void save() {
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        Customer savedCustomer = CustomerService.save(customer);
        assertNotNull(savedCustomer.getId());
    }
}