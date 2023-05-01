package com.astontech.resthr.services;

import com.astontech.resthr.domain.Vehicle;

public interface VehicleService {

    Vehicle findByVinOrId(String vin, Integer id);

    Iterable<Vehicle> findAll();
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);
    void deleteVehicle(Integer id);

}
