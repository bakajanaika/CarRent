package com.example.demo.repos;

import com.example.demo.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    @Query(value = "select * from price where car_id =:carId and start_date<now() and now()<end_date", nativeQuery = true)
    public Price priceFinder(int carId);



}
