package com.example.server.vehicleProject.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;                // auto generated uuid PK

    @Column(scale = 7, name = "lPlate", unique = true, nullable = false)
    private String licensePlate;    // pt : Placa de licensa

    @Column(scale = 20, unique = true, nullable = false)
    private String chassis;         // pt : numero de chassi

    @Column(scale = 40, nullable = false)
    private String modelName;       // pt : Modelo

    @Column(nullable = true)
    private int cc;                 // pt : (anulavel) cilindradas

    public Vehicle(String licensePlate, String chassis, String modelName, int cc) {
        this.licensePlate = licensePlate;
        this.chassis = chassis;
        this.modelName = modelName;
        this.cc = cc;
    }

    public Vehicle() {
    }

    public Vehicle(String licensePlate, String chassis, String modelName) {
        this.licensePlate = licensePlate;
        this.chassis = chassis;
        this.modelName = modelName;
        this.cc = -1;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public UUID getUuid(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Vehicle [cc=" + cc + ", chassis=" + chassis + ", id=" + id + ", licensePlate=" + licensePlate
                + ", modelName=" + modelName + "]";
    }

}
