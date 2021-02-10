package com.elcentr.dao;

import com.elcentr.model.Customer;
import com.elcentr.model.Order;
import com.elcentr.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;

class OrderDAOTest {

    @Test
    void save() {

        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        customerDAO.save(customer);

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code(21021002)
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        productDAO.save(product);

        Order order = Order.builder()
                .customer(customer)
                .product(product)
                .build();
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.save(order);

    }

}