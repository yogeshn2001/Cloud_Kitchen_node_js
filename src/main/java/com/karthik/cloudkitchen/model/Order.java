package com.karthik.cloudkitchen.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import org.hibernate.mapping.List;

import jakarta.persistence.*;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Order_id;

    // @ElementCollection
    private String dishName; // Changed type to List<String>

    //private String catererName;
    private LocalDate deliveryDate;
    private int numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public Order() {
    this.dishName = null;
    this.deliveryDate = LocalDate.now(); // Set the default delivery date to the current date
    this.numberOfPeople = 0; // Set the default number of people to 0
}

    public Order(String dishName, 
    //String catererName, 
    LocalDate deliveryDate, int numberOfPeople, User user) {
        this.dishName = dishName;
        //this.catererName = catererName;
        this.deliveryDate = deliveryDate;
        this.numberOfPeople = numberOfPeople;
        this.user = user;
    }

  

    // Getters and setters
    public Long getorder_id() {
        return Order_id;
    }

    public void setOrder_id(Long Order_id) {
        this. Order_id = Order_id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    // public String getCatererName() {
    //     return catererName;
    // }

    // public void setCatererName(String catererName) {
    //     this.catererName = catererName;
    // }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
