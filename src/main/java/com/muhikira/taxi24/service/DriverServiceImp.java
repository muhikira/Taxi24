package com.muhikira.taxi24.service;

import com.muhikira.taxi24.entity.Driver;
import org.springframework.stereotype.Service;
import com.muhikira.taxi24.repository.DriverRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImp implements DriverService {
    private DriverRepository driverRepository;

    public  DriverServiceImp(DriverRepository theDriverRepository){

        this.driverRepository = theDriverRepository;
    }
    @Override
    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    @Override
    public Driver findById( Long theId ) {
        Optional<Driver> result = driverRepository.findById(theId);

        Driver theDriver = null;
        if (result.isPresent()) {
            theDriver = result.get();
        } else {
            // we didn't find the driver

            throw new RuntimeException("Did not find driver id -" + theId);
        }
        return theDriver;
    }

    @Override
    public void save(Driver theDriver) {
        driverRepository.save(theDriver);

    }

    @Override
    public Driver update( long driverId, Driver updatedDriver ) {
        Optional<Driver> result = driverRepository.findById(driverId);

        Driver theDriver = null;
        if (result.isPresent()) {
            theDriver = result.get();
            theDriver.setFirstName(updatedDriver.getFirstName());
            theDriver.setLastName(updatedDriver.getLastName());
            theDriver.setStatus(updatedDriver.getStatus());
            driverRepository.save(theDriver);
        } else {

            // we didn't find the driver

            throw new RuntimeException("Did not find driver id -" + driverId);
        }

        return theDriver;
    }

    @Override
    public void deleteById(long driverId) {
        driverRepository.deleteById(driverId);

    }
}
