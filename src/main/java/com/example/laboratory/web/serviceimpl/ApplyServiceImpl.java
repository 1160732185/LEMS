package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Apply;
import com.example.laboratory.persistence.mapper.ApplyMapper;
import com.example.laboratory.web.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplyServiceImpl implements ApplyService {
    @Autowired
    ApplyMapper applyMapper;
    @Override
    public Integer getApplyCount() { return applyMapper.getApplyCount(); }
    public Integer getApplyCountS(Integer staffNo) { return applyMapper.getApplyCountS(staffNo); }
    public List<Apply> getAllApplyS(Integer staffNo,Integer firstRow,Integer pageSize) { return applyMapper.getAllApplyS(staffNo,firstRow,pageSize); }
    public List<Apply> getAllApply(Integer firstRow,Integer pageSize) { return applyMapper.getAllApply(firstRow,pageSize); }

    @Override
    public List<Apply> getApplyByTypeS(String applyType, Integer staffNo, Integer firstRow, Integer pageSize) {
        return applyMapper.getApplyByTypeS(applyType,staffNo,firstRow,pageSize);
    }

    @Override
    public List<Apply> getApplyByType(String applyType, Integer firstRow, Integer pageSize) {
        return applyMapper.getApplyByType(applyType,firstRow,pageSize);
    }

    @Override
    public List<Apply> getApplyByStateS(String applyState, Integer staffNo, Integer firstRow, Integer pageSize) {
        return applyMapper.getApplyByStateS(applyState,staffNo,firstRow,pageSize);
    }

    @Override
    public List<Apply> getApplyByState(String applyState, Integer firstRow, Integer pageSize) {
        return applyMapper.getApplyByState(applyState,firstRow,pageSize);
    }

    public Apply getApplyByNoS(String applyNo,Integer staffNo) { return applyMapper.getApplyByNoS(applyNo,staffNo); }
    public Apply getApplyByNo(String applyNo) { return applyMapper.getApplyByNo(applyNo); }
    public void insertApply(Apply apply){applyMapper.insertApply(apply);}
    public void updateApply(Apply apply) { applyMapper.updateApply(apply); }
    public void updateApplyS(Apply apply) { applyMapper.updateApplyS(apply); }
    public void deleteApply(String No) { applyMapper.deleteApply(No); }
}
