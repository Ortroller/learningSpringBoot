package com.example.server.vehicleProject.repository;

// import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.server.vehicleProject.models.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, UUID>{

    public Vehicle findByLicensePlate(String LicensePlate);
    public Vehicle findByChassis(String chassis);
}
