package com.muhikira.taxi24.service;

import com.muhikira.taxi24.entity.Driver;

import java.util.List;

public interface DriverService {
    public List<Driver> getAll();
    public Driver findById(Long theId);
    public void save(Driver theDriver);
    public Driver update(long driverId, Driver updatedDriver);
    public void deleteById(long driverId);

}
