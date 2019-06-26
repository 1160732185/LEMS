package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Apply;
import com.example.laboratory.common.model.ApplyDetail;
import com.example.laboratory.persistence.mapper.ApplyDetailMapper;
import com.example.laboratory.persistence.mapper.ApplyMapper;
import com.example.laboratory.web.service.ApplyDetailService;
import com.example.laboratory.web.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplyDetailServiceImpl implements ApplyDetailService {
    @Autowired
    ApplyDetailMapper applyDetailMapper;
    @Override
    public Integer getApplyDetailCountByApplyNo(String applyNo) {
        return applyDetailMapper.getApplyDetailCountByApplyNo(applyNo);
    }

    @Override
    public List<ApplyDetail> getAllApplyDetailByApplyNo(String applyNo, Integer firstRow, Integer pageSize) {
        return applyDetailMapper.getAllApplyDetailByApplyNo(applyNo,firstRow,pageSize);
    }

    @Override
    public void insertApplyDetail(ApplyDetail applyDetail) {
applyDetailMapper.insertApplyDetail(applyDetail);
    }

    @Override
    public void updateApplyDetail(ApplyDetail applyDetail) {
applyDetailMapper.updateApplyDetail(applyDetail);
    }

    @Override
    public void deleteApplyDetail(String applyNo, String modelNo) {
applyDetailMapper.deleteApplyDetail(applyNo,modelNo);
    }
}
