package com.example.server.vehicleProject.models;

import java.util.UUID;

import javax.persistence.*;


@Entity()
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // PK com geracao automatica no banco

    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String dob;
    
    public Person() {
    }

    public Person(String nome, String cpf, String dob) {
        this.nome = nome;
        this.cpf = cpf;
        this.dob = dob;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Pessoa [cpf=" + cpf + ", dob=" + dob + ", id=" + id + ", nome=" + nome + "]";
    }
    
    
}
