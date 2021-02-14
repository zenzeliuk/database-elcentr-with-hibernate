package com.elcentr.service;

import com.elcentr.dao.EnclosureDAO;
import com.elcentr.model.Enclosure;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class EnclosureService {

    private static EnclosureDAO enclosureDAO = new EnclosureDAO();

    public static Enclosure save(Enclosure enclosure) {
        if (nonNull(enclosure.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return enclosureDAO.save(enclosure);
    }

    public static Enclosure update(Enclosure enclosure) {
        if (isNull(enclosure.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return enclosureDAO.update(enclosure);
    }

    public static Enclosure read(Enclosure enclosure) {
        if (isNull(enclosure)) {
            throw new RuntimeException("Search is failed!");
        }
        return enclosureDAO.findById(enclosure.getId());
    }

    public static void delete(Enclosure enclosure) {
        if (isNull(enclosure.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        enclosureDAO.delete(enclosure);
    }

}
