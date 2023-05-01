package com.astontech.resthr.services;

import com.astontech.resthr.domain.Model;
import com.astontech.resthr.exceptions.ModelAlreadyExistsException;
import com.astontech.resthr.exceptions.ModelNotFoundException;
import com.astontech.resthr.repositories.ModelRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService{

    private ModelRepo modelRepo;

    public ModelServiceImpl(ModelRepo modelRepo) {
        this.modelRepo = modelRepo;
    }

    @Override
    public Model findByModelNameOrId(String modelName, Integer id) {
        return modelRepo.findByModelNameOrId(modelName, id)
                .orElseThrow(() -> new ModelNotFoundException(modelName == null ? String.valueOf(id) : modelName));
    }

    @Override
    public Iterable<Model> findAll() {
        return modelRepo.findAll();
    }

    @Override
    public Model saveModel(Model model) {
        Optional<Model> existingModel = modelRepo.findByModelNameOrId(model.getModelName(), null);
        if(existingModel.isEmpty()) {
            return modelRepo.save(model);
        } else {
            throw new ModelAlreadyExistsException(model.getModelName());
        }

    }

    @Override
    public Model updateModel(Model model) {
        return modelRepo.save(model);
    }

    @Override
    public void deleteModel(Model model) {
        modelRepo.delete(model);
    }

    @Override
    public void deleteModel(Integer id) {
        modelRepo.deleteById(id);
    }
}
