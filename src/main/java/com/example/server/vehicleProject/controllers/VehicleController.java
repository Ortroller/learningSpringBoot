package com.example.server.vehicleProject.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Vehicle updateVehicle(@RequestBody Vehicle v, HttpServletResponse response) throws NullPointerException{
        Vehicle vehicle = service.updateVehicle(v);

        if(vehicle == null){
            response.setStatus(404);
            return vehicle;
        }

        response.setStatus(200);
        return vehicle;
    }
    

    @RequestMapping(path = "/", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteVehicle(@RequestParam UUID id, HttpServletResponse response){

        if(id == null){
            response.setStatus(400); // Bad Request
            return def_statusMessage("id must be informed");
        }
        boolean statusService = service.deleteVehicleByID(id);

        if (statusService){
            response.setStatus(200);
            return def_statusMessage("Deleted");
        }else{
            response.setStatus(404);
            return def_statusMessage("Not Deleted");
        }

    }
    
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String nullHandler(DataIntegrityViolationException ex){
        return ex.getMessage();
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String excHandler(Exception ex){
        return ex.getMessage();
    }

    private String def_statusMessage(String statusMessage){
        return "{status :" + statusMessage + "}";
    }
    
}
