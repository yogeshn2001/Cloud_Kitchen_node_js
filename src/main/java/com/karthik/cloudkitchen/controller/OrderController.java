package com.karthik.cloudkitchen.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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
private User user;

@PostMapping("/saveOrder")
@ResponseBody
public void saveOrder(HttpServletRequest request, Principal principal) {
    String dishNames = request.getParameter("dishName"); // Retrieve dish names as String array
   // List<String> dishNameList = Arrays.asList(dishNames); // Convert String array to List<String>

    LocalDate deliveryDate = LocalDate.parse(request.getParameter("deliveryDate"));
    int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));

    // Get the authenticated user object
    Long userId = user.getId(); // Get the username from Principal
    User user = userService.findById(userId); // Assuming you have a method to find User by username

    // Create Order object
    Order order = new Order(dishNames, deliveryDate, numberOfPeople, user);

    // Save the order
    orderService.saveOrder(order);
}

    
}