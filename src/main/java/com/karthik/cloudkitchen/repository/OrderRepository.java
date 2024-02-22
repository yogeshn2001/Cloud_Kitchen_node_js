package com.karthik.cloudkitchen.repository;
import com.karthik.cloudkitchen.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

    
    
}
