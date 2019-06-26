package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Device;
import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.DeviceService;
import com.example.laboratory.web.service.StaffService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

@Api
@RestController
@RequestMapping("api/v1")
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    @Autowired
    StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    @ApiOperation(value = "获取设备列表", notes = "获取设备列表", produces = "application/json")
    @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    @RequestMapping(value = "/device", method = RequestMethod.GET,produces = "application/json")
    public List<Device> getAllDevice(@RequestParam("staffNo") Integer staffNo) {
        Staff staff = staffService.getStaffByNo(staffNo);
        if (staff.getStaffDuty().equals("普通员工")) {
            return deviceService.getAllDeviceS(staffNo);
        }else {
            return deviceService.getAllDevice();
        }
    }

    @ApiOperation(value = "获取设备数量", notes = "获取设备数量", produces = "application/json")
    @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    @RequestMapping(value = "/device/count", method = RequestMethod.GET,produces = "application/json")
    public MessageBox getApplySum(@RequestParam("staffNo") Integer staffNo) {
        MessageBox messageBox = new MessageBox();
        Staff staff = staffService.getStaffByNo(staffNo);
        if (staff.getStaffDuty().equals("普通员工")) {
            messageBox.setMessage("total");
            messageBox.setStatus(deviceService.getDeviceCountS(staffNo));
            return messageBox;
        } else {
            messageBox.setMessage("total");
            messageBox.setStatus(deviceService.getDeviceCount());
            return messageBox;
        }
    }



    @ApiOperation(value = "根据No获取设备", notes = "根据No获取设备", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/device/{deviceNo}", method = RequestMethod.GET,produces = "application/json")
    public Device getDevice(@PathVariable("deviceNo")String deviceNo){
        Device deviceBean=null;
        deviceBean=deviceService.getDeviceByNo(deviceNo);
        if(deviceBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该设备信息！").getMessage());
        }
        return deviceBean;
    }

    @ApiOperation(value = "添加设备", notes = "添加设备", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "device", value = "device", dataType = "Device", paramType = "body"),
    })
    @RequestMapping(value = "/device", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertDevice(@RequestBody Device device)
    {
        MessageBox messageBox=new MessageBox();
        try{
            deviceService.insertDevice(device);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_DEVICE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_DEVICE_SUCCESS_CODE);
        messageBox.setMessage("insert device success"+device.getDeviceNo());
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "更新设备", notes = "更新设备", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "device", value = "device", dataType = "Device", paramType = "body"),
    })
    @RequestMapping(value = "/device", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateDevice(@RequestBody Device device)
    {
        MessageBox messageBox=new MessageBox();
        try{
            deviceService.updateDevice(device);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_DEVICE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_DEVICE_SUCCESS_CODE);
        messageBox.setMessage("update device success");
        logger.info(messageBox.getMessage()+device.getDeviceNo());
        return messageBox;
    }

    @ApiOperation(value = "删除设备", notes = "删除设备", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/device/{deviceNo}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteUser(@PathVariable("deviceNo") String deviceNo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            deviceService.deleteDevice(deviceNo);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_DEVICE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_DEVICE_SUCCESS_CODE);
        messageBox.setMessage("delete device success");
        logger.info(messageBox.getMessage()+deviceNo);
        return messageBox;
    }

}
