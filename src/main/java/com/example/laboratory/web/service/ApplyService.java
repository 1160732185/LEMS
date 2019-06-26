package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Apply;

import java.util.List;

public interface ApplyService {
    Integer getApplyCount();
    Integer getApplyCountS(Integer staffNo);
    List<Apply> getAllApplyS(Integer staffNo,Integer firstRow,Integer pageSize);
    List<Apply> getAllApply(Integer firstRow,Integer pageSize);
    Apply getApplyByNo(Integer applyNo);
    Apply getApplyByNoS(Integer applyNo,Integer staffNo);
    void insertApply(Apply apply);
    void updateApply(Apply apply);
    void deleteApply(Integer No);
}
