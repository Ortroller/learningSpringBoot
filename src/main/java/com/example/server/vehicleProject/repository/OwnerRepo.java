package com.example.server.vehicleProject.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.server.vehicleProject.models.OwnerRegistry;
import com.example.server.vehicleProject.models.Person;
import com.example.server.vehicleProject.models.Vehicle;

public interface OwnerRepo extends JpaRepository<OwnerRegistry, UUID>{
    
    public List<OwnerRegistry> findByOwner(Person owner);
    public List<OwnerRegistry> findByVehicle(Vehicle vehicle);
}
