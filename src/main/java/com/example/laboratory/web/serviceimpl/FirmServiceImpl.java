package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Firm;
import com.example.laboratory.persistence.mapper.FirmMapper;
import com.example.laboratory.web.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FirmServiceImpl implements FirmService {
    @Autowired
    FirmMapper firmMapper;
    @Override
    public List<Firm> getAllFirm(Integer firstRow,Integer pageSize) { return firmMapper.getAllFirm(firstRow,pageSize); }
    public Firm getFirmByNo(Integer No) { return firmMapper.getFirmByNo(No); }
    public void insertFirm(Firm firm){firmMapper.insertFirm(firm);}
    public void updateFirm(Firm firm) { firmMapper.updateFirm(firm); }
    public void deleteFirm(Integer No) { firmMapper.deleteFirm(No); }
    public Integer getFirmCount(){return firmMapper.getFirmCount();}
}
