package com.easy.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    int carId;
    String brand;
    String type;
    int noOfPassengers;
    String transmissionType;
    double dailyRate;
    double monthlyRate;
    String fuelType;
    double priceForExtraKM;
    String regNo;
    String color;
}
