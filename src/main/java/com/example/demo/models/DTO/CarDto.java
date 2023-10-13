package com.example.demo.models.DTO;

import com.example.demo.models.Manufacturer;
import lombok.Data;

@Data
public class CarDto {
    private Long id;
    private String name;
    private String manufacturerName;
    private String imageUrl;
}
