package com.astontech.resthr.repositories;

import org.springframework.data.repository.CrudRepository;
import com.astontech.resthr.domain.Vehicle;

import java.util.Optional;

public interface VehicleRepo extends CrudRepository<Vehicle, Integer> {

    Vehicle findByVin(String vin);
    Optional<Vehicle> findByVinOrId(String vin, Integer id);


}



