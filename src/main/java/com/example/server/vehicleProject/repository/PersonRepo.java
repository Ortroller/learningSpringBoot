package com.example.server.vehicleProject.repository;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.server.vehicleProject.models.Person;


@Repository
public interface PersonRepo extends JpaRepository<Person, UUID>{

    
    public Person findByCpf(String cpf);

    public List<Person> findByNome(String nome);
    
}
