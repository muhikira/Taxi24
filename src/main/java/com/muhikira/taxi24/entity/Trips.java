package com.muhikira.taxi24.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Trips {
    // Define fields
    private Long id;
    private Driver driver;
    private  Rider rider;
    private TripStatus tripStatus;

    // Define constructors
    // define getters and setters
    // define toString
}
