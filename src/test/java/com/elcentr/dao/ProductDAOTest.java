package com.elcentr.dao;

import com.elcentr.model.Customer;
import com.elcentr.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {

    @Test
    void save() {

        Product product = new Product();
        product.setAmountProduct(1);
        product.setCodeProduct(21020801);
        product.setNameProduct("ГРЩ2");

        ProductDAO productDAO = new ProductDAO();
        productDAO.save(product);
        System.out.println(product);





//        Customer customer = Customer.builder()
//                .name("КАН")
//                .notes("test_notes")
//                .build();
//        Customer savedCustomer = new CustomerDAO().save(customer);
//        assertNotNull(savedCustomer.getId());
    }

    @Test
    void findById() {
        Customer customer = Customer.builder()
                .name("КАН")
                .notes("test_notes")
                .build();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());

        Customer foundCustomer = customerDAO.findById(savedCustomer.getId());
        assertNotNull(foundCustomer);
    }

    @Test
    void delete() {
        Customer customer = Customer.builder()
                .name("КАН")
                .notes("test_notes")
                .build();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());

        customerDAO.delete(savedCustomer);
        Customer afterDelete = customerDAO.findById(savedCustomer.getId());
        assertNull(afterDelete);
    }

    @Test
    void update() {
        Customer customer = Customer.builder()
                .name("КАН")
                .notes("test_notes")
                .build();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());
        String nameBeforeUpdate = savedCustomer.getName();

        savedCustomer.setName("Міськжитлобуд");
        customerDAO.update(savedCustomer);
        String nameAfterUpdate = savedCustomer.getName();

        assertFalse(nameBeforeUpdate.equals(nameAfterUpdate));
    }
}