package com.astontech.resthr.services;

import com.astontech.resthr.domain.Make;
import com.astontech.resthr.domain.Model;

public interface ModelService {

    Model findByModelNameOrId(String modelName, Integer id);

    Iterable<Model> findAll();
    Model saveModel(Model model);
    Model updateModel(Model model);
    void deleteModel(Model model);
    void deleteModel(Integer id);

}
