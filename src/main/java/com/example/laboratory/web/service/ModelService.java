package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Model;
import com.example.laboratory.common.model.Room;

import java.util.List;

public interface ModelService {
    Integer getModelCount();
    List<Model> getAllModel();
    Model getModelByNo(String No);
    void insertModel(Model model);
    void updateModel(Model model);
    void deleteModel(String No);
}
