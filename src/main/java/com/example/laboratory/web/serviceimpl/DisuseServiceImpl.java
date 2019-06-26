package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Disuse;
import com.example.laboratory.persistence.mapper.DisuseMapper;
import com.example.laboratory.web.service.DisuseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DisuseServiceImpl implements DisuseService {
    @Autowired
    DisuseMapper disuseMapper;
    @Override
    public Integer getDisuseCount() { return disuseMapper.getDisuseCount(); }
    public Integer getDisuseCountS(Integer staffNo) { return disuseMapper.getDisuseCountS(staffNo); }
    public List<Disuse> getAllDisuseS(Integer staffNo, Integer firstRow, Integer pageSize) { return disuseMapper.getAllDisuseS(staffNo,firstRow,pageSize); }
    public List<Disuse> getAllDisuse(Integer firstRow,Integer pageSize) { return disuseMapper.getAllDisuse(firstRow,pageSize); }
    public List<Disuse> getAllDisuseByDisuseStateS(Integer staffNo,String disuseState , Integer firstRow, Integer pageSize){return disuseMapper.getAllDisuseByDisuseStateS(staffNo,disuseState,firstRow,pageSize);}
    public List<Disuse> getAllDisuseByDisuseState(Integer firstRow,String disuseState ,Integer pageSize){return disuseMapper.getAllDisuseByDisuseState(firstRow,disuseState,pageSize);}
    public Disuse getDisuseByNoS(String disuseNo,Integer staffNo) { return disuseMapper.getDisuseByNoS(disuseNo,staffNo); }
    public Disuse getDisuseByNo(String disuseNo) { return disuseMapper.getDisuseByNo(disuseNo); }
    public Disuse getDisuseByDeviceNo(String deviceNo) { return disuseMapper.getDisuseByDeviceNo(deviceNo); }
    public void insertDisuse(Disuse disuse){disuseMapper.insertDisuse(disuse);}
    public void updateDisuse(Disuse disuse) { disuseMapper.updateDisuse(disuse); }
    public void updateDisuseS(Disuse disuse) { disuseMapper.updateDisuseS(disuse); }
    public void deleteDisuse(String No) { disuseMapper.deleteDisuse(No); }
}
