package com.example.demo.repos;

import com.example.demo.models.Car;
import com.example.demo.models.DTO.CarDto;
import org.mapstruct.Mapper;


public interface CarDtoMapper {
    CarDto carDTO(Car car);
}
