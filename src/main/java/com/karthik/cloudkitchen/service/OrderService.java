package com.karthik.cloudkitchen.service;
import com.karthik.cloudkitchen.model.Order;
import com.karthik.cloudkitchen.repository.OrderRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
   
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}