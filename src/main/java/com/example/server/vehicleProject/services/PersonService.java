package com.example.server.vehicleProject.services;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import com.example.server.vehicleProject.models.Person;
import com.example.server.vehicleProject.repository.PersonRepo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class PersonService {

    private final PersonRepo personRepository; // DB Reference 

    // @Autowired
    public PersonService(PersonRepo personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public Person getPersonByID(UUID id){
        return personRepository.findById(id).get();
    }

    @Transactional
    public String deletePersonbyCPF(String cpf){
        String name;
        
        try{ // Verificando se existe uma pessoa com o uuid informado.
            Person p = personRepository.findByCpf(cpf);
            name = p.getNome();
            personRepository.delete(p);
        }catch(EntityNotFoundException ex){
            name = "RUIM";
        }

        return name;
    }

    @Transactional // E bom ter em todos os metodos que envolvem transaca com o banco?
    public String deletePersonsByNameDBG(String name){

        List<Person> pQuerryList = personRepository.findByNome(name);
        int quantity = pQuerryList.size();
        for(Person p : pQuerryList){
            personRepository.delete(p);
        }
        return "Deleted " + quantity;
    }
    
    @Transactional // Forca o update? 
    public Person updatePerson(Person p){

        Person person = personRepository.findByCpf(p.getCpf());

        person.setCpf(p.getCpf());
        person.setNome(p.getNome());
        person.setDob(p.getDob());

        return person;
    }

    // @ExceptionHandler()
    // public void handlerError(){

    // }
}
