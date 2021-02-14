package com.elcentr.service;

import com.elcentr.dao.CustomerDAO;
import com.elcentr.model.Customer;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class CustomerService {

    private static CustomerDAO customerDAO = new CustomerDAO();

    public static Customer save(Customer customer) {
        if (nonNull(customer.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return customerDAO.save(customer);
    }

    public static Customer update(Customer customer) {
        if (isNull(customer.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return customerDAO.update(customer);
    }

    public static Customer read(Customer customer) {
        if (isNull(customer)) {
            throw new RuntimeException("Search is failed!");
        }
        return customerDAO.findById(customer.getId());
    }

    public static void delete(Customer customer) {
        if (isNull(customer.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        customerDAO.delete(customer);
    }

}