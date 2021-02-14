package com.elcentr.service;

import com.elcentr.dao.CustomerDAO;
import com.elcentr.model.Customer;

import static java.util.Objects.nonNull;

public class CustomerService {

    private static CustomerDAO customerDAO  = new CustomerDAO();

    public static Customer save (Customer customer){
        if (nonNull(customer.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return customerDAO.save(customer);
    }


}
