package com.example.server.vehicleProject.models;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "owner")
public class OwnerRegistry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Person owner;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Vehicle vehicle;
}
