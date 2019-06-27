package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Repair;

import java.util.List;

public interface RepairService {
    Integer getRepairCount();
    Integer getRepairCountS(Integer staffNo);
    List<Repair> getAllRepairS(Integer staffNo, Integer firstRow, Integer pageSize);
    List<Repair> getAllRepair(Integer firstRow,Integer pageSize);
    Repair getRepairByNo(String repairNo);
    Repair getRepairByDevice(String deviceNo);
    Repair getRepairByNoS(String repairNo,Integer staffNo);
    void insertRepair(Repair repair);
    void updateRepair(Repair repair);
    void deleteRepair(String No);
}
