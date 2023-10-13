package com.example.demo.services;

import org.springframework.http.ResponseEntity;

public interface CarService {
    public ResponseEntity<?> isCarAvailable(Long id);

}
