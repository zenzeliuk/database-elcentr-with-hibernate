package com.elcentr.dao;

import com.elcentr.model.Customer;
import com.elcentr.model.Enclosure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnclosureDAOTest {

    @Test
    void save(){
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        Enclosure savedEnclosure = new EnclosureDAO().save(enclosure);
        assertNotNull(savedEnclosure);
    }

    @Test
    void findById() {
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());

        Enclosure foundEnclosure = enclosureDAO.findById(savedEnclosure.getId());
        assertNotNull(foundEnclosure);
    }

    @Test
    void delete() {
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());

        enclosureDAO.delete(savedEnclosure);
        Enclosure afterDelete = enclosureDAO.findById(savedEnclosure.getId());
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