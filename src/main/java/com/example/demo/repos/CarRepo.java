package com.example.demo.repos;

import com.example.demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CarRepo extends JpaRepository<Car, Integer> {
    Car findCarByName(String car);
    List<Car> findCarByManufacturer_Name(String mnfName);
    List<Car> findCarByManufacturer_Country(String mnfCountry);
    Car findCarById(Long id);



}
