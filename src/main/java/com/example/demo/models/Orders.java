package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Price price;
    private double sum;
    private LocalDate date;
    @ElementCollection
    private List<LocalDate> dates;
    @ManyToOne
   
    private Client client;
    @ManyToOne
    @JoinColumn
    private Car car;

}
