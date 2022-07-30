package com.example.server.vehicleProject.controllers;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.vehicleProject.models.OwnerRegistry;
import com.example.server.vehicleProject.models.Person;
import com.example.server.vehicleProject.models.Vehicle;
import com.example.server.vehicleProject.services.OwnerService;
import com.example.server.vehicleProject.services.PersonService;
import com.example.server.vehicleProject.services.VehicleService;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping(value = "owner")
public class OwnerController {
    
    @Autowired
    private final OwnerService service;
    @Autowired
    private final PersonService pService;
    @Autowired
    private final VehicleService vService;

    public OwnerController(OwnerService service, PersonService pService, VehicleService vService) {
        this.service = service;
        this.pService = pService;
        this.vService = vService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public OwnerRegistry createRegistry(@RequestBody String data , HttpServletResponse response) throws ParseException{
        
        LinkedHashMap<String, Object> obj = new JSONParser(data).parseObject();

        String personID = obj.get("personID").toString();
        String vehicleID = obj.get("vehicleID").toString();

        Person pTemp = pService.getPersonByID(UUID.fromString(personID));
        Vehicle vTemp = vService.getVehicleById(UUID.fromString(vehicleID));

        // System.out.println(pTemp.getNome());
        // System.out.println(vTemp.getModelName());
        if(pTemp == null || vTemp == null){
            // se algum nao for encontrado
            response.setStatus(401);
            return null;
        }
        return service.createRegistry(new OwnerRegistry(pTemp, vTemp));
        // return null;

    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<OwnerRegistry> listOwnerRecords(){
        return service.allRegistry();
    }
    
}
