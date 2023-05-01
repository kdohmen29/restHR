package com.astontech.resthr.controllers;


import com.astontech.resthr.domain.Make;
import com.astontech.resthr.domain.Model;
import com.astontech.resthr.domain.Vehicle;
import com.astontech.resthr.exceptions.MakeAlreadyExistsException;
import com.astontech.resthr.exceptions.MakeNotFoundException;
import com.astontech.resthr.exceptions.ModelNotFoundException;
import com.astontech.resthr.exceptions.VehicleNotFoundException;
import com.astontech.resthr.services.MakeService;
import com.astontech.resthr.services.ModelService;
import com.astontech.resthr.services.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/make")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MakeRest {


    private MakeService makeService;
    private ModelService modelService;
    private VehicleService vehicleService;

    public MakeRest(MakeService makeService, ModelService modelService, VehicleService vehicleService) {
        this.makeService = makeService;
        this.modelService = modelService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Make>> getAllMakes() {
        return ResponseEntity.ok(makeService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Make> addMake(@RequestBody Make make) {
        String makeName = make.getMakeName();
        String vehicleVin = (make.getModelList().get(0).getVehicleList().get(0).getVin());
        String modelName = (make.getModelList().get(0).getModelName());
        Make fetchedMake = null;
        Model fetchedModel = null;
        Vehicle fetchedVin = null;
        Model newModel = make.getModelList().get(0);
        Vehicle newVehicle = make.getModelList().get(0).getVehicleList().get(0);

        try {
            fetchedMake = makeService.findByMakeNameOrId(makeName, null);
        } catch (MakeNotFoundException ignored) {
        }
        try {
            fetchedModel = modelService.findByModelNameOrId(modelName, null);
        } catch (ModelNotFoundException ignored) {
        }
        try {
            fetchedVin = vehicleService.findByVinOrId(vehicleVin, null);
        } catch (VehicleNotFoundException ignored) {
        }

        if (fetchedMake == null) {
            return new ResponseEntity<>(
                    makeService.saveMake(make),
                    HttpStatus.CREATED
            );
        } else if (fetchedModel == null) {

            fetchedMake.getModelList().add(newModel);

            return new ResponseEntity<>(
                    makeService.updateMake(fetchedMake),
                    HttpStatus.ACCEPTED
            );

        } else if (fetchedVin == null) {

            fetchedModel.getVehicleList().add(newVehicle);
            modelService.updateModel(fetchedModel);

            return new ResponseEntity<>(
                    HttpStatus.ACCEPTED
            );
        } else {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PutMapping("/")
    public ResponseEntity<Make> updateMake(@RequestBody Make make) {
        return new ResponseEntity<>(
                makeService.saveMake(make),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping("/")
    public void deleteMake(@RequestBody Make make) {
        makeService.deleteMake(make);
    }

    @DeleteMapping("/{id}")
    public void deleteMakeById(@PathVariable Integer id) {
        makeService.deleteMake(id);
    }

    //query params

    @GetMapping()
    public ResponseEntity<Make> findByIdOrMakeName(@RequestParam(required = false) Integer id,
                                                   @RequestParam(required = false) String makeName) {
        return ResponseEntity.ok(makeService.findByMakeNameOrId(makeName, id));
//                    .orElseThrow(() -> new MakeNotFoundException(makeName));
//        } else if(id != null) {
//            return makeService.findByMakeNameOrId(null, id)
//                    .orElseThrow(() -> new MakeNotFoundException(Integer.toString(id)));
//        } else {
//            //throw exception
//            throw new MakeNotFoundException((makeName == null ? Integer.toString(id) : makeName));
//        }
    }

    // Path Param
    @GetMapping("/{id}")
    public ResponseEntity<Make> findByIdInPath(@PathVariable Integer id) {
//        Optional<Make> makeOptional = makeService.findById(id);
//        return makeOptional.orElseThrow(() -> new MakeNotFoundException(Integer.toString(id)));

        return ResponseEntity.ok(makeService.findByMakeNameOrId(null, id));
    }
}
