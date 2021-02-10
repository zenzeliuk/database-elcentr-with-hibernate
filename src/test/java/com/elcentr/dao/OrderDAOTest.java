package com.elcentr.dao;

import com.elcentr.model.Customer;
import com.elcentr.model.Order;
import com.elcentr.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderDAOTest {

    @Test
    void save() {

        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code(21021002)
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        OrderDAO orderDAO = new OrderDAO();
        Order order = Order.builder()
                .customer(savedCustomer)
                .product(savedProduct)
                .build();
        Order savedOrder = orderDAO.save(order);
        assertNotNull(savedOrder.getId());

    }


//    void findById() {
//
//        CustomerDAO customerDAO = new CustomerDAO();
//        Customer customer = Customer.builder()
//                .name("test-name")
//                .build();
//        customerDAO.save(customer);
//
//        ProductDAO productDAO = new ProductDAO();
//        Product product = Product.builder()
//                .amount(1)
//                .code(21021002)
//                .name("test-name")
//                .timeRegistration(new Date().getTime())
//                .build();
//        productDAO.save(product);
//
//        Order order = Order.builder()
//                .customer(customer)
//                .product(product)
//                .build();
//        OrderDAO orderDAO = new OrderDAO();
//        orderDAO.save(order);
//
//    }

}