package com.astontech.resthr.repositories;

import com.astontech.resthr.domain.Make;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface MakeRepo extends CrudRepository<Make, Integer> {
    Optional<Make> findByMakeName(String makeName);
    Optional<Make> findByMakeNameOrId(String makeName, Integer id);


}
