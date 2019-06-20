package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.StaffService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StaffController {
    @Autowired
    StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @ApiOperation(value = "获取员工列表", notes = "获取员工列表", produces = "application/json")
    @RequestMapping(value = "/staff", method = RequestMethod.GET,produces = "application/json")
    public List<Staff> getAllStaff() {
    return staffService.getAllStaff();
    }

    @ApiOperation(value = "根据No获取用户", notes = "根据No获取用户", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/staff/{staffNo}", method = RequestMethod.GET,produces = "application/json")
    public Staff getStaff(@PathVariable("staffNo")String staffNo){
        int No=-1;
        try{
            No=Integer.valueOf(staffNo);
        } catch (NumberFormatException e)
        {

        }
        Staff staffBean=null;
        if(No!=-1)
            staffBean=staffService.getStaffByNo(Integer.valueOf(staffNo));
        if(staffBean==null)
        {
                        logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage());
        }
        return staffBean;
    }

    @ApiOperation(value = "添加员工", notes = "添加员工", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staff", value = "staff", dataType = "Staff", paramType = "body"),
    })
    @RequestMapping(value = "/staff", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertParent(@RequestBody Staff staff)
    {
        MessageBox messageBox=new MessageBox();
        try{
            staff.setStaffRegisterTime(new Date());
            staffService.insertStaff(staff);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_STAFF_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_STAFF_SUCCESS_CODE);
        messageBox.setMessage("insert staff success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

}
