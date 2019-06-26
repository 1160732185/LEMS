package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Model;
import com.example.laboratory.common.model.Room;
import com.example.laboratory.persistence.mapper.ModelMapper;
import com.example.laboratory.persistence.mapper.RoomMapper;
import com.example.laboratory.web.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<Model> getAllModel() { return modelMapper.getAllModel(); }
    public Model getModelByNo(String No) { return modelMapper.getModelByNo(No); }
    public void insertModel(Model model){modelMapper.insertModel(model);}
    public void updateModel(Model model) { modelMapper.updateModel(model); }
    public void deleteModel(String No) { modelMapper.deleteModel(No); }
    public Integer getModelCount(){return modelMapper.getModelCount();}
}
