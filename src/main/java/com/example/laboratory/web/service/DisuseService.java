package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Disuse;

import java.util.List;

public interface DisuseService {
    Integer getDisuseCount();
    Integer getDisuseCountS(Integer staffNo);
    List<Disuse> getAllDisuseS(Integer staffNo, Integer firstRow, Integer pageSize);
    List<Disuse> getAllDisuse(Integer firstRow,Integer pageSize);
    Disuse getDisuseByNo(Integer disuseNo);
    Disuse getDisuseByNoS(Integer disuseNo,Integer staffNo);
    void insertDisuse(Disuse disuse);
    void updateDisuse(Disuse disuse);
    void updateDisuseS(Disuse disuse);
    void deleteDisuse(Integer No);
}
