package com.astontech.resthr.services;

import com.astontech.resthr.domain.Vehicle;
import com.astontech.resthr.exceptions.VinAlreadyExistsException;
import com.astontech.resthr.repositories.VehicleRepo;
import org.springframework.stereotype.Service;
import com.astontech.resthr.exceptions.VehicleNotFoundException;

import java.util.Optional;


@Service
public class VehicleServiceImpl implements VehicleService{

    private VehicleRepo vehicleRepo;

    public VehicleServiceImpl(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public Vehicle findByVinOrId(String vin, Integer id) {
        return vehicleRepo.findByVinOrId(vin, id)
                .orElseThrow(() -> new VehicleNotFoundException(vin == null ? String.valueOf(id) : vin));
    }

    @Override
    public Iterable<Vehicle> findAll() {
        return vehicleRepo.findAll();
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        Optional<Vehicle> existingVehicle = vehicleRepo.findByVinOrId(vehicle.getVin(), null);
        if(existingVehicle.isEmpty()) {
            return vehicleRepo.save(vehicle);
        } else {
            throw new VinAlreadyExistsException(vehicle.getVin());
        }
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepo.delete(vehicle);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepo.deleteById(id);
    }
}
