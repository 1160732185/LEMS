package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Device;
import com.example.laboratory.common.model.Model;

import java.util.List;

public interface DeviceService {

    Integer getDeviceCount();
    Integer getDeviceCountS(Integer staffNo);
    List<Device> getAllDevice();
    List<Device> getAllDeviceS(Integer staffNo);
    Device getDeviceByNo(String No);
    void insertDevice(Device device);
    void updateDevice(Device device);
    void deleteDevice(String No);
}
