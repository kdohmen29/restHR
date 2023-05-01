package com.astontech.resthr.controllers;



import com.astontech.resthr.domain.Model;
import com.astontech.resthr.domain.Vehicle;

import com.astontech.resthr.services.ModelService;
import com.astontech.resthr.services.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VehicleRest {

    private ModelService modelService;
    private VehicleService vehicleService;

    public VehicleRest(ModelService modelService, VehicleService vehicleService) {
        this.modelService = modelService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/") //http://localhost:8080/vehicle/
    public ResponseEntity<Iterable<Vehicle>> getAllVehicles() {
        System.out.println("finding all vehicles");
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(
                vehicleService.saveVehicle(vehicle),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(
                vehicleService.saveVehicle(vehicle),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping("/")
    public void deleteVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.deleteVehicle(vehicle);
    }

    @DeleteMapping("/{idc}/{parentName}")
    public void deleteVehicleById(@PathVariable Integer idc,
                                    @PathVariable String parentName) {
        Model fetchedModel = modelService.findByModelNameOrId(parentName, null);
        fetchedModel.getVehicleList().remove(vehicleService.findByVinOrId(null, idc));
        vehicleService.deleteVehicle(idc);
    }

    @GetMapping()
    public ResponseEntity<Vehicle> findByIdOrVin(   @RequestParam(required = false) Integer id,
                                                    @RequestParam(required = false) String vin) {
        return ResponseEntity.ok(vehicleService.findByVinOrId(vin, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findByIdInPath(@PathVariable Integer id) {
//        Optional<Make> makeOptional = makeService.findById(id);
//        return makeOptional.orElseThrow(() -> new MakeNotFoundException(Integer.toString(id)));

        return ResponseEntity.ok(vehicleService.findByVinOrId(null, id));
    }
}
