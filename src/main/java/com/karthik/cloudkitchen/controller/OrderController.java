package com.karthik.cloudkitchen.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.karthik.cloudkitchen.model.Order;
import com.karthik.cloudkitchen.model.User;
import com.karthik.cloudkitchen.service.OrderService;
import com.karthik.cloudkitchen.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import java.security.Principal;


@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

   @Autowired
    private UserService userService;
// private User user;

@PostMapping("/saveOrder")
@ResponseBody
public void saveOrder(HttpServletRequest request, Principal principal) {
    String dishNames = request.getParameter("dishNames");
    // String[] dishNames = dishNameString.split(","); 
    LocalDate deliveryDate = LocalDate.parse(request.getParameter("deliveryDate"));
    int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));

    // Get the authenticated user's ID
    Long userId = Long.parseLong(principal.getName());

    // Find the user by their ID
    User user = userService.findById(userId);

    // Create Order object
    Order order = new Order(dishNames, deliveryDate, numberOfPeople, user);

    // Save the order
    orderService.saveOrder(order);
}



    
}