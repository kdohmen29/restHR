package com.astontech.resthr.services;


import com.astontech.resthr.domain.Make;
import com.astontech.resthr.domain.Model;
import com.astontech.resthr.domain.Vehicle;
import com.astontech.resthr.exceptions.MakeAlreadyExistsException;
import com.astontech.resthr.exceptions.MakeNotFoundException;
import com.astontech.resthr.repositories.MakeRepo;
import com.astontech.resthr.repositories.ModelRepo;
import com.astontech.resthr.repositories.VehicleRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakeServiceImpl implements MakeService {

    private MakeRepo makeRepo;
    private ModelRepo modelRepo;
    private VehicleRepo vehicleRepo;

    public MakeServiceImpl(MakeRepo makeRepo) {
        this.makeRepo = makeRepo;
    }

    @Override
    public Make findByMakeNameOrId(String makeName, Integer id) {
        return makeRepo.findByMakeNameOrId(makeName, id)
                .orElseThrow(() -> new MakeNotFoundException(makeName == null ? String.valueOf(id) : makeName));
    }

    @Override
    public Iterable<Make> findAll() {
        return makeRepo.findAll();
    }

    @Override
    public Make saveMake(Make make) {
        Optional<Make> existingMake = makeRepo.findByMakeNameOrId(make.getMakeName(), null);
        if(existingMake.isEmpty()) {
            return makeRepo.save(make);

        } else {
            throw new MakeAlreadyExistsException(make.getMakeName());
        }
    }

    @Override
    public Make updateMake(Make make) {
        return makeRepo.save(make);
    }

    @Override
    public void deleteMake(Make make) {
        makeRepo.delete(make);
    }

    @Override
    public void deleteMake(Integer id) {
        makeRepo.deleteById(id);
    }


}
