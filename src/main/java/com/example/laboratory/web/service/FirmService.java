package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Firm;
import com.example.laboratory.common.model.Room;

import java.util.List;

public interface FirmService {
    List<Firm> getAllFirm(Integer firstRow,Integer pageSize);
    Firm getFirmByNo(Integer No);
    void insertFirm(Firm firm);
    void updateFirm(Firm firm);
    void deleteFirm(Integer No);
    Integer getFirmCount();
}
