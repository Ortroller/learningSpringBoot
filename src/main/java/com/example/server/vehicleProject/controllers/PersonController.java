package com.example.server.vehicleProject.controllers;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.vehicleProject.models.Person;
import com.example.server.vehicleProject.services.PersonService;


@RestController()
@RequestMapping(value = "pessoa")
public class PersonController {

    private final PersonService personservice;

    // @Autowired
    public PersonController(PersonService personservice) {
        this.personservice = personservice;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List<Person> getPersons() {
        return this.personservice.getPersons();
    }

    @RequestMapping(method=RequestMethod.POST, path = "/")
    public String addPerson(@RequestBody Person p) {

        personservice.addPerson(p);

        return "OK";
    }

    @RequestMapping(value="/", method=RequestMethod.DELETE)
    public String deletePerson(@RequestParam String cpf) {
        String name;

        name = personservice.deletePersonbyCPF(cpf);

        return "deleted " + name; 
    }
    
    @RequestMapping(value="nome/", method=RequestMethod.DELETE)
    public String deletePersonsWithName(@RequestParam String name) {
        return personservice.deletePersonsByNameDBG(name); 
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String updatePerson(@RequestBody Person P){
        
        return personservice.updatePerson(P).getId().toString();
    }
}
