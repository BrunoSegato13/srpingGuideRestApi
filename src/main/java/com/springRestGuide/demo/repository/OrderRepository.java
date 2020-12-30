package com.springRestGuide.demo.repository;

import com.springRestGuide.demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
