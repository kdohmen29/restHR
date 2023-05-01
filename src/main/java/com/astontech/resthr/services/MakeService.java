package com.astontech.resthr.services;

import com.astontech.resthr.domain.Make;

public interface MakeService {

    Make findByMakeNameOrId(String makeName, Integer id);

    Iterable<Make> findAll();
    Make saveMake(Make make);
    Make updateMake(Make make);
    void deleteMake(Make make);
    void deleteMake(Integer id);
}
