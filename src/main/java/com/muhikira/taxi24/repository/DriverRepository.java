package com.muhikira.taxi24.repository;

import com.muhikira.taxi24.entity.Driver;
import com.muhikira.taxi24.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {



}
