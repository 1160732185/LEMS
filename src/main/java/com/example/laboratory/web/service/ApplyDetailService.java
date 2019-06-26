package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Apply;
import com.example.laboratory.common.model.ApplyDetail;

import java.util.List;

public interface ApplyDetailService {
    Integer getApplyDetailCountByApplyNo(String applyNo);
    List<ApplyDetail> getAllApplyDetailByApplyNo(String applyNo, Integer firstRow, Integer pageSize);
    void insertApplyDetail(ApplyDetail applyDetail);
    void updateApplyDetail(ApplyDetail applyDetail);
    void deleteApplyDetail(String applyNo,String modelNo);
}
