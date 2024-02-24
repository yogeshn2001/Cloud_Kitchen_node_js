package com.karthik.cloudkitchen.repository;
import com.karthik.cloudkitchen.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
    List<Order> findByUserId(Long userId);
    
    
}
