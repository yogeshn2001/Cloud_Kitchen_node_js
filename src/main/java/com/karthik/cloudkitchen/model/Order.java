package com.karthik.cloudkitchen.model;

import java.time.LocalDate;
import java.util.List;

//import org.hibernate.mapping.List;

import jakarta.persistence.*;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Order_id;

    @ElementCollection
    private List<String> dishName; // Changed type to List<String>

    //private String catererName;
    private LocalDate deliveryDate;
    private int numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public Order(List<String> dishName, 
    //String catererName, 
    LocalDate deliveryDate, int numberOfPeople, User user) {
        this.dishName = dishName;
        //this.catererName = catererName;
        this.deliveryDate = deliveryDate;
        this.numberOfPeople = numberOfPeople;
        this.user = user;
    }

    public Order(String dishName2, 
   // String catererName2, 
    LocalDate deliveryDate2, int numberOfPeople2) {
        //TODO Auto-generated constructor stub
    }

    // Getters and setters
    public Long getorder_id() {
        return Order_id;
    }

    public void setOrder_id(Long Order_id) {
        this. Order_id = Order_id;
    }

    public List<String> getDishName() {
        return dishName;
    }

    public void setDishName(List<String> dishName) {
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
