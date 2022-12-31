package com.muhikira.taxi24.rest;

import com.muhikira.taxi24.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.muhikira.taxi24.service.DriverService;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverRestController {
    @Autowired
    private DriverService driverService;

    public DriverRestController(DriverService theDriverService){
        this.driverService = theDriverService;

    }

    // expose "/drivers" and return list of employees
    @GetMapping("/drivers")
    public List<Driver> findAll() {
        return driverService.getAll();
    }

    // add mapping for GET /drivers/{driverId}

    @GetMapping("/drivers/{driverId}")
    public Driver getEmployee(@PathVariable long driverId) {

        Driver theDriver  = driverService.findById(driverId);

        if (theDriver  == null) {
            throw new RuntimeException("Driver id not found - " + driverId);
        }

        return theDriver;
    }

    // add mapping for POST /drivers - add new driver

    @PostMapping("/drivers")
    public Driver addDriver( @RequestBody Driver theDriver ) {

    //    theDriver.setId(0L);

        driverService.save(theDriver);

        return theDriver;
    }

    // add mapping for PUT /drivers - update existing drivers

    @PutMapping("/drivers/{driverId}")
    public Driver updateDriver(@PathVariable Long driverId,@RequestBody Driver theDriver) {

        return driverService.update(driverId,theDriver);
    }

    // add mapping for DELETE /drivers/{driverId} - delete driver

    @DeleteMapping("/drivers/{driverId}")
    public String deleteDriver(@PathVariable Long driverId) {

        Driver tempDriver = driverService.findById(driverId);

        // throw exception if null

        if (tempDriver == null) {
            throw new RuntimeException("Driver id not found - " + driverId);
        }
//
        driverService.deleteById(driverId);

        return "Deleted employee id - " + driverId;
    }
}
