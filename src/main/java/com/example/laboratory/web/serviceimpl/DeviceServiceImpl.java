package com.example.laboratory.web.serviceimpl;

import com.example.laboratory.common.model.Device;
import com.example.laboratory.persistence.mapper.DeviceMapper;
import com.example.laboratory.web.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    @Override
    public List<Device> getAllDevice() { return deviceMapper.getAllDevice(); }
    public Device getDeviceByNo(String No) { return deviceMapper.getDeviceByNo(No); }
    public void insertDevice(Device device){deviceMapper.insertDevice(device);}
    public void updateDevice(Device device) { deviceMapper.updateDevice(device); }
    public void deleteDevice(String No) { deviceMapper.deleteDevice(No); }
}
