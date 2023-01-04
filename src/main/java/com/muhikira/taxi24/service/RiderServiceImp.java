package com.muhikira.taxi24.service;

import com.muhikira.taxi24.entity.Rider;
import com.muhikira.taxi24.repository.RiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RiderServiceImp implements RiderService {
    private RiderRepository riderRepository;


    public RiderServiceImp(RiderRepository theRiderRepository) {
        this.riderRepository=theRiderRepository;
    }
    public List<Rider> getAll(){
        return riderRepository.findAll();
    }

    @Override
    public Rider findById(Long theId) {
        Optional<Rider> result = riderRepository.findById(theId);
        Rider theRider=null;
        if(result.isPresent()){
            theRider = result.get();
        } else{
            throw new RuntimeException("Did not found the rider id" + theId);
        }
        return theRider;
    }

    @Override
    public void save(Rider theRider) {
        riderRepository.save(theRider);

    }

    @Override
    public Rider update(long riderId, Rider updateRider) {
        Optional<Rider> result = riderRepository.findById(riderId);
        Rider theRider = null;
        if(result.isPresent()){
            theRider = result.get();
            theRider.setFirstName(updateRider.getFirstName());
            theRider.setLastName(updateRider.getLastName());
            theRider.setLocation(updateRider.getLocation());
            riderRepository.save(theRider);
        } else{
            throw new RuntimeException("Did not find the Rider id "+riderId);
        }
        return theRider;
    }

    @Override
    public void deleteById(long riderId) {
        riderRepository.deleteById(riderId);

    }
}
