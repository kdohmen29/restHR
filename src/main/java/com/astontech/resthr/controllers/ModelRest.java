package com.astontech.resthr.controllers;

import com.astontech.resthr.domain.Make;
import com.astontech.resthr.domain.Model;

import com.astontech.resthr.services.MakeService;
import com.astontech.resthr.services.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ModelRest {


    private ModelService modelService;
    private MakeService makeService;

    public ModelRest(ModelService modelService, MakeService makeService) {
        this.modelService = modelService;
        this.makeService = makeService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Model>> getAllModels() {
        System.out.println("Finding all models");
        return ResponseEntity.ok(modelService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Model> addModel(@RequestBody Model model) {
        return new ResponseEntity<>(
                modelService.saveModel(model),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Model> updateModel(@RequestBody Model model) {
        return new ResponseEntity<>(
                modelService.saveModel(model),
                HttpStatus.ACCEPTED
        );
    }

    @DeleteMapping("/")
    public void deleteModel(@RequestBody Model model) {
        modelService.deleteModel(model);
    }

    @DeleteMapping("/{idc}/{parentName}")
    public void deleteModelById(@PathVariable Integer idc,
                                @PathVariable String parentName) {
        Make fetchedMake = makeService.findByMakeNameOrId(parentName, null);
        fetchedMake.getModelList().remove(modelService.findByModelNameOrId(null, idc));
        modelService.deleteModel(idc);
    }

    @GetMapping()
    public ResponseEntity<Model> findByIdOrModelName(@RequestParam(required = false) Integer id,
                                   @RequestParam(required = false) String modelName) {
        return ResponseEntity.ok(modelService.findByModelNameOrId(modelName, id));
        }

    @GetMapping("/{id}")
    public ResponseEntity<Model> findByIdInPath(@PathVariable Integer id) {
//        Optional<Model> makeOptional = makeService.findById(id);
//        return makeOptional.orElseThrow(() -> new ModelNotFoundException(Integer.toString(id)));

        return ResponseEntity.ok(modelService.findByModelNameOrId(null, id));
    }
}


