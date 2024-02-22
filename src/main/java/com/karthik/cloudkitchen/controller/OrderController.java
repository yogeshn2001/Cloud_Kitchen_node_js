package com.karthik.cloudkitchen.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.karthik.cloudkitchen.model.Order;
import com.karthik.cloudkitchen.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    @ResponseBody
    public void saveOrder(HttpServletRequest request) {
        String dishName = request.getParameter("dishName");
        //String catererName = request.getParameter("catererName");
        LocalDate deliveryDate = LocalDate.parse(request.getParameter("deliveryDate"));
        int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));


        // Create Order object
        Order order = new Order(dishName, 
       // catererName, 
        deliveryDate, numberOfPeople);

        // Save the order
        orderService.saveOrder(order);
    }
}