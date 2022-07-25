package com.example.server.vehicleProject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.vehicleProject.models.Vehicle;
import com.example.server.vehicleProject.services.VehicleService;

@RestController()
@RequestMapping(value = "veiculo/")
public class VehicleController {
    
    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String addVehicle(@RequestBody Vehicle v){
        return service.addVehicle(v);
    }

    @RequestMapping(path = "/license/", method = RequestMethod.GET)
    public Vehicle getVehicleWithLP(@RequestParam(name = "license") String licensePlate){
        return service.getVehicleByLincensePlate(licensePlate);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Vehicle> getAllVehiclesDB(){
        return service.getAllVehicle();
    }

    @RequestMapping(path="/", method=RequestMethod.PUT)
    public Vehicle requestMethodName(@RequestBody Vehicle v, HttpServletResponse response) throws NullPointerException{
        Vehicle vehicle = service.updateVehicle(v);

        if(vehicle == null){
            response.setStatus(404);
            return vehicle;
        }

        response.setStatus(200);
        return vehicle;
    }
    
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String nullHandler(DataIntegrityViolationException ex){
        return ex.getMessage();
    }
    
}
