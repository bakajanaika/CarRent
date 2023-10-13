package com.example.demo.repos;

import com.example.demo.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

    List<Orders> findAllByCar_IdAndDatesContaining(Long id, LocalDate now);
}
