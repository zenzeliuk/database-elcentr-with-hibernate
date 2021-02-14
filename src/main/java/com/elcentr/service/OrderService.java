package com.elcentr.service;

import com.elcentr.dao.OrderDAO;
import com.elcentr.model.Order;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class OrderService {

    private static OrderDAO orderDAO = new OrderDAO();

    public static Order save(Order order) {
        if (nonNull(order.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return orderDAO.save(order);
    }

    public static Order update(Order order) {
        if (isNull(order.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return orderDAO.update(order);
    }

    public static Order read(Order order) {
        if (isNull(order)) {
            throw new RuntimeException("Search is failed!");
        }
        return orderDAO.findById(order.getId());
    }

    public static void delete(Order order) {
        if (isNull(order.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        orderDAO.delete(order);
    }

}
