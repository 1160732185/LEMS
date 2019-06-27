package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Repair;
import com.example.laboratory.persistence.mapper.RepairMapper;
import com.example.laboratory.web.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RepairServiceImpl implements RepairService {
    @Autowired
    RepairMapper repairMapper;
    @Override
    public Integer getRepairCount() { return repairMapper.getRepairCount(); }
    public Integer getRepairCountS(Integer staffNo) { return repairMapper.getRepairCountS(staffNo); }
    public List<Repair> getAllRepairS(Integer staffNo, Integer firstRow, Integer pageSize) { return repairMapper.getAllRepairS(staffNo,firstRow,pageSize); }
    public List<Repair> getAllRepair(Integer firstRow,Integer pageSize) { return repairMapper.getAllRepair(firstRow,pageSize); }
    public Repair getRepairByNoS(String repairNo,Integer staffNo) { return repairMapper.getRepairByNoS(repairNo,staffNo); }
    public Repair getRepairByNo(String repairNo) { return repairMapper.getRepairByNo(repairNo); }
    public Repair getRepairByDevice(String deviceNo){ return repairMapper.getRepairByDevice(deviceNo); }
    public void insertRepair(Repair repair){repairMapper.insertRepair(repair);}
    public void updateRepair(Repair repair) { repairMapper.updateRepair(repair);}
    public void deleteRepair(String No) { repairMapper.deleteRepair(No); }
}
