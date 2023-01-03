package com.muhikira.taxi24.service;

import com.muhikira.taxi24.entity.Driver;
import com.muhikira.taxi24.entity.Rider;
import com.muhikira.taxi24.repository.DriverRepository;
import com.muhikira.taxi24.repository.RiderRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceDriver {
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;

    public ServiceDriver(DriverRepository driverRepository, RiderRepository riderRepository) {
        this.driverRepository = driverRepository;
        this.riderRepository = riderRepository;
    }

    public void assignRiderToDriver(Long driverId, Long riderId) {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() -> new RuntimeException("Driver not found"));
        Rider rider = riderRepository.findById(riderId).orElseThrow(() -> new RuntimeException("Rider not found"));
        rider.setDriver(driver);
        riderRepository.save(rider);
    }
}
