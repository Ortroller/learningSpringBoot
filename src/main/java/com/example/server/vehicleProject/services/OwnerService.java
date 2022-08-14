package com.example.server.vehicleProject.services;

import com.example.server.vehicleProject.models.OwnerRegistry;
import com.example.server.vehicleProject.models.Person;
import com.example.server.vehicleProject.models.Vehicle;
import com.example.server.vehicleProject.repository.OwnerRepo;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OwnerService {

    private OwnerRepo repository;

    public OwnerService(OwnerRepo repository) {
        this.repository = repository;
    }


    public List<OwnerRegistry> allRegistry(){
        return repository.findAll();
    }

    @Transactional
    public OwnerRegistry createRegistry(OwnerRegistry reg){
        return repository.save(reg);
    }

    public List<OwnerRegistry> getAllRegistryByOwner(Person owner){
        return repository.findByOwner(owner);
    }

    public List<OwnerRegistry> getAllRegistryByVehicle(Vehicle vehicle){
        return repository.findByVehicle(vehicle);
    }

    @Transactional
    public boolean deleteRegistry(UUID id){

        if (repository.findById(id).isEmpty()){
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Transactional
    public OwnerRegistry updateRegistry(OwnerRegistry reg){
        OwnerRegistry p = repository.findById(reg.getId()).get();

        if(p == null){
            return null;
        }

        p.setOwner(reg.getOwner());
        p.setVehicle(reg.getVehicle());
        
        return p;
    }
}
