package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Disuse;

import java.util.List;

public interface DisuseService {
    Integer getDisuseCount();
    Integer getDisuseCountS(Integer staffNo);
    List<Disuse> getAllDisuseS(Integer staffNo, Integer firstRow, Integer pageSize);
    List<Disuse> getAllDisuse(Integer firstRow,Integer pageSize);
    List<Disuse> getAllDisuseByDisuseStateS(Integer staffNo,String disuseState, Integer firstRow, Integer pageSize);
    List<Disuse> getAllDisuseByDisuseState(Integer firstRow,String disuseState,Integer pageSize);
    Integer getAllDisuseByDisuseStateCS(Integer staffNo,String disuseState);
    Integer getAllDisuseByDisuseStateC(String disuseState);
    Disuse getDisuseByNo(String disuseNo);
    Disuse getDisuseByNoS(String disuseNo,Integer staffNo);
    Disuse getDisuseByDeviceNo(String disuseNo);
    void insertDisuse(Disuse disuse);
    void updateDisuse(Disuse disuse);
    void updateDisuseS(Disuse disuse);
    void deleteDisuse(String No);
}
