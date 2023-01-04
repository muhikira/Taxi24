package com.muhikira.taxi24.service;

import com.muhikira.taxi24.entity.Rider;

import java.util.List;

public interface RiderService {
    public List<Rider> getAll();
    public Rider findById(Long theId);
    public void save(Rider theRider);
    public Rider update (long riderId, Rider updateRider);
    public void deleteById(long riderId);


}
