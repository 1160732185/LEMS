package com.example.laboratory.web.service;

import com.example.laboratory.common.model.Device;
import com.example.laboratory.common.model.Model;

import java.util.List;

public interface DeviceService {
    List<Device> getAllDevice();
    Device getDeviceByNo(String No);
    void insertDevice(Device device);
    void updateDevice(Device device);
    void deleteDevice(String No);
}
