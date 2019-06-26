package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.StaffService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

@Api
@RestController
@RequestMapping("api/v1")
public class StaffController {
    @Autowired
    StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @ApiOperation(value = "获取员工数量", notes = "获取员工数量", produces = "application/json")
    @RequestMapping(value = "/staff/count", method = RequestMethod.GET,produces = "application/json")
    public MessageBox getStaffSum() {
        MessageBox messageBox = new MessageBox();
        messageBox.setStatus(staffService.getStaffCount());
        messageBox.setMessage("total");
        return messageBox;
    }


/*    @Secured({"ROLE_管理员"})*/
    @ApiOperation(value = "获取员工列表", notes = "获取员工列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "pageIndex", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "/staff", method = RequestMethod.GET,produces = "application/json")
    public List<Staff> getAllStaff(@RequestParam Integer pageIndex,@RequestParam Integer pageSize) {
    logger.info("有人获取员工列表");
    Integer firstRow=pageIndex*pageSize;
        return staffService.getAllStaff(firstRow,pageSize);
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
    public MessageBox insertStaff(@RequestBody Staff staff)
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
        messageBox.setMessage(staff.getStaffNo().toString());
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "更新员工", notes = "更新员工", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staff", value = "staff", dataType = "Staff", paramType = "body"),
    })
    @RequestMapping(value = "/staff", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateStaff(@RequestBody Staff staff)
    {
        MessageBox messageBox=new MessageBox();
        try{
            staff.setStaffRegisterTime(new Date());
            staffService.updateStaff(staff);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_STAFF_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_STAFF_SUCCESS_CODE);
        messageBox.setMessage("update staff success");
        logger.info(messageBox.getMessage()+staff.getStaffName());
        return messageBox;
    }

    @ApiOperation(value = "删除员工", notes = "删除员工", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/staff/{staffNo}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteUser(@PathVariable("staffNo") String staffNo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            staffService.deleteStaff(Integer.valueOf(staffNo));
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_STAFF_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_STAFF_SUCCESS_CODE);
        messageBox.setMessage("delete user success");
        logger.info(messageBox.getMessage()+staffNo);
        return messageBox;
    }

}
