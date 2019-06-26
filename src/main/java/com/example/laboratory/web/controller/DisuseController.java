package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Disuse;
import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.DisuseService;
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
public class DisuseController {
    @Autowired
    DisuseService disuseService;
    @Autowired
    StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(DisuseController.class);

    @ApiOperation(value = "获取报废单数量", notes = "获取报废单数量", produces = "application/json")
    @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    @RequestMapping(value = "/disuse/count", method = RequestMethod.GET,produces = "application/json")
    public MessageBox getDisuseSum(@RequestParam("staffNo") Integer staffNo) {
        MessageBox messageBox=new MessageBox();
        Staff staff = staffService.getStaffByNo(staffNo);
        if(staff.getStaffDuty().equals("普通员工")) {
            messageBox.setMessage("total");
            messageBox.setStatus(disuseService.getDisuseCountS(staffNo));
            return messageBox;
        }
        messageBox.setMessage("total");
        messageBox.setStatus(disuseService.getDisuseCount());
        return messageBox;
    }



    @ApiOperation(value = "获取报废单列表", notes = "获取报废单列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "pageIndex", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/disuse", method = RequestMethod.GET,produces = "application/json")
    public List<Disuse> getAllDisuse(@RequestParam("staffNo")Integer staffNo,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize) {
        Staff staff = staffService.getStaffByNo(staffNo);
        Integer firstRow=pageIndex*pageSize;
        if(staff.getStaffDuty().equals("普通员工")) {
            return disuseService.getAllDisuseS(staffNo,firstRow,pageSize);
        }
        return disuseService.getAllDisuse(firstRow,pageSize);
    }


    @ApiOperation(value = "根据No获取报废单", notes = "根据No获取报废单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "disuseNo", value = "disuseNo", dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/disuse/{disuseNo}", method = RequestMethod.GET,produces = "application/json")
    public Disuse getDisuse(@PathVariable("disuseNo")Integer disuseNo,@RequestParam("staffNo")Integer staffNo){
        Staff staff = staffService.getStaffByNo(staffNo);
        Disuse disuseBean=null;
        if(staff.getStaffDuty().equals("普通员工")){
            disuseBean=disuseService.getDisuseByNoS(disuseNo,staffNo);
        }else{
            disuseBean=disuseService.getDisuseByNo(disuseNo);
        }
        if(disuseBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该报废单信息！").getMessage());
        }
        return disuseBean;
    }

    @ApiOperation(value = "添加报废单", notes = "添加报废单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "disuse", value = "disuse", dataType = "Disuse", paramType = "body"),
    })
    @RequestMapping(value = "/disuse", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertDisuse(@RequestBody Disuse disuse)
    {
        MessageBox messageBox=new MessageBox();
        try{
            disuse.setDisuseDate(new Date());
            String str="D";
            for(int i=0;i<11;i++){
                char c = (char)((int)(Math.random()*10+48));
                str+=c;
            }
            disuse.setDisuseNo(str);
            disuseService.insertDisuse(disuse);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_DISUSE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_DISUSE_SUCCESS_CODE);
        messageBox.setMessage(disuse.getDisuseNo());
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "更新报废单", notes = "更新报废单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "disuse", value = "disuse", dataType = "Disuse", paramType = "body"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/disuse", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateDisuse(@RequestParam("staffNo") Integer staffNo, @RequestBody Disuse disuse)
    {
        Disuse disusebean = disuseService.getDisuseByNo(Integer.parseInt(disuse.getDisuseNo()));
        MessageBox messageBox=new MessageBox();
        if(disusebean.getDisuseState().equals("已通过")||disusebean.getDisuseState().equals("未通过")){
            messageBox.setStatus(MessageBox.UPDATE_DISUSE_FAILURE_CODE);
            messageBox.setMessage("订单已处理，不可修改");
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        Staff staff = staffService.getStaffByNo(staffNo);
        try{
            if(staff.getStaffDuty().equals("普通员工")){
                disuse.setDisuseDate(new Date());
                disuse.setDisuseStaffNo(staff.getStaffNo());
                disuseService.updateDisuseS(disuse);
            }else{
                disuse.setDisuseUpdateDate(new Date());
                disuse.setCheckStaffNo(staff.getStaffNo());
                disuseService.updateDisuse(disuse);
            }
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_DISUSE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_DISUSE_SUCCESS_CODE);
        messageBox.setMessage("update disuse success");
        logger.info(messageBox.getMessage()+disuse.getDisuseNo());
        return messageBox;
    }

    @ApiOperation(value = "删除报废单", notes = "删除报废单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "disuseNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/disuse/{disuseNo}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteUser(@PathVariable("disuseNo") String disuseNo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            disuseService.deleteDisuse(Integer.valueOf(disuseNo));
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_DISUSE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_DISUSE_SUCCESS_CODE);
        messageBox.setMessage("delete disuse success");
        logger.info(messageBox.getMessage()+disuseNo);
        return messageBox;
    }

}
