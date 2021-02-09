package com.elcentr.dao;

import com.elcentr.model.ResidentialComplex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResidentialComplexDAOTest {

    @Test
    void save() {
        ResidentialComplex residentialComplex = ResidentialComplex.builder()
                .name("Файна таун")
                .address("вул. Салютна, 2б")
                .build();
        ResidentialComplex savedRC = new ResidentialComplexDAO().save(residentialComplex);
        assertNotNull(savedRC.getId());
    }

    @Test
    void findById() {
        ResidentialComplex residentialComplex = ResidentialComplex.builder()
                .name("Файна таун")
                .address("вул. Салютна, 2б")
                .build();
        ResidentialComplexDAO residentialComplexDAO = new ResidentialComplexDAO();
        ResidentialComplex savedRC = residentialComplexDAO.save(residentialComplex);
        assertNotNull(savedRC.getId());

        ResidentialComplex foundRC = residentialComplexDAO.findById(savedRC.getId());
        assertNotNull(foundRC);
    }

    @Test
    void delete() {
        ResidentialComplex residentialComplex = ResidentialComplex.builder()
                .name("Файна таун")
                .address("вул. Салютна, 2б")
                .build();
        ResidentialComplexDAO residentialComplexDAO = new ResidentialComplexDAO();
        ResidentialComplex savedRC = residentialComplexDAO.save(residentialComplex);
        assertNotNull(savedRC.getId());

        residentialComplexDAO.delete(savedRC);
        ResidentialComplex afterDelete = residentialComplexDAO.findById(savedRC.getId());
        assertNull(afterDelete);
    }

    @Test
    void update() {
        ResidentialComplex residentialComplex = ResidentialComplex.builder()
                .name("Файна таун")
                .address("вул. Смалютна, 2б")
                .build();
        ResidentialComplexDAO residentialComplexDAO = new ResidentialComplexDAO();
        ResidentialComplex savedRC = residentialComplexDAO.save(residentialComplex);
        assertNotNull(savedRC.getId());
        String nameBeforeUpdate = savedRC.getAddress();

        savedRC.setAddress("вул. Салютна, 2б");
        residentialComplexDAO.update(savedRC);
        String nameAfterUpdate = savedRC.getAddress();

        assertFalse(nameBeforeUpdate.equals(nameAfterUpdate));
    }
}