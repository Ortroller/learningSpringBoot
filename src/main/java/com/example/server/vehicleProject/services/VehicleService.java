package com.example.server.vehicleProject.services;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.server.vehicleProject.models.Vehicle;
import com.example.server.vehicleProject.repository.VehicleRepo;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepo repository;

    // @Autowired
    public VehicleService(VehicleRepo repository) {
        this.repository = repository;
    }

    public Vehicle getVehicleByLincensePlate(String license){
        return repository.findByLicensePlate(license);
    }

    @Transactional
    public String addVehicle(Vehicle vehicle){
        String message;
        try{
            message = repository.save(vehicle).getUuid().toString();

        }catch(Exception ex){
            message = "Falha";
        }
        return message;
    }

    @Transactional
    public List<Vehicle> getAllVehicle(){
        return repository.findAll();
    }

    @Transactional
    public Vehicle updateVehicle(Vehicle v){
        Vehicle inst;
        try{
            inst = repository.findByChassis(v.getChassis());
            inst.setCc(v.getCc());
            inst.setLicensePlate(v.getLicensePlate());
            inst.setModelName(v.getModelName());
        }catch(Exception ex){
            inst = null;
        }

        return inst;
    }

    @Transactional
    public boolean deleteVehicleByID(UUID id){
        
        if (repository.findById(id).isEmpty()){
            return false;
        }

        repository.deleteById(id);

        return true;
    }
    
}
