package com.elcentr.service;

import com.elcentr.dao.ResidentialComplexDAO;
import com.elcentr.model.ResidentialComplex;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ResidentialComplexService {

    private static ResidentialComplexDAO residentialComplexDAO = new ResidentialComplexDAO();

    public static ResidentialComplex save(ResidentialComplex residentialComplex) {
        if (nonNull(residentialComplex.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return residentialComplexDAO.save(residentialComplex);
    }

    public static ResidentialComplex update(ResidentialComplex residentialComplex) {
        if (isNull(residentialComplex.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return residentialComplexDAO.update(residentialComplex);
    }

    public static ResidentialComplex read(ResidentialComplex residentialComplex) {
        if (isNull(residentialComplex)) {
            throw new RuntimeException("Search is failed!");
        }
        return residentialComplexDAO.findById(residentialComplex.getId());
    }

    public static void delete(ResidentialComplex residentialComplex) {
        if (isNull(residentialComplex.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        residentialComplexDAO.delete(residentialComplex);
    }

}
