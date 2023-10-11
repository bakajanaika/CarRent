package com.example.demo.repos;

import com.example.demo.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer> {

}
