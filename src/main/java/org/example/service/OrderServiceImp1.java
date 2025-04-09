package org.example.service;

import org.example.dao.OrderDao;
import org.example.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp1 implements OrderService {
    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImp1(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order createOrder(String customerName, String product, double amount) {
        Order order = new Order(null, customerName, product, amount);
        return orderDao.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDao.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public void cancelOrder(Long id) {
        orderDao.deleteById(id);
    }
}
