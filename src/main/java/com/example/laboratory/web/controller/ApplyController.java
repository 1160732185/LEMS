package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Apply;
import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.ApplyService;
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
public class ApplyController {
    @Autowired
    ApplyService applyService;
    @Autowired
    StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(ApplyController.class);

    @ApiOperation(value = "获取申请单数量", notes = "获取申请单数量", produces = "application/json")
    @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    @RequestMapping(value = "/apply/count", method = RequestMethod.GET,produces = "application/json")
    public MessageBox getApplySum(@RequestParam("staffNo") Integer staffNo) {
        MessageBox messageBox=new MessageBox();
        Staff staff = staffService.getStaffByNo(staffNo);
        if(staff.getStaffDuty().equals("普通员工")) {
            messageBox.setMessage("total");
            messageBox.setStatus(applyService.getApplyCountS(staffNo));
            return messageBox;
        }
        messageBox.setMessage("total");
        messageBox.setStatus(applyService.getApplyCount());
        return messageBox;
    }



    @ApiOperation(value = "获取申请单列表", notes = "获取申请单列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "pageIndex", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/apply", method = RequestMethod.GET,produces = "application/json")
    public List<Apply> getAllApply(@RequestParam("staffNo")Integer staffNo,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize) {
        Staff staff = staffService.getStaffByNo(staffNo);
        Integer firstRow=pageIndex*pageSize;
        System.out.println("findallpageIndex"+pageIndex);
        System.out.println("findallpageSize"+pageSize);
        if(staff.getStaffDuty().equals("普通员工")) {
            return applyService.getAllApplyS(staffNo,firstRow,pageSize);
        }
        return applyService.getAllApply(firstRow,pageSize);
    }


    @ApiOperation(value = "根据No获取申请单", notes = "根据No获取申请单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyNo", value = "applyNo", dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/apply/{applyNo}", method = RequestMethod.GET,produces = "application/json")
    public Apply getApplyByNo(@PathVariable("applyNo")String applyNo,@RequestParam("staffNo")Integer staffNo){
        Staff staff = staffService.getStaffByNo(staffNo);
        Apply applyBean=null;
        if(staff.getStaffDuty().equals("普通员工")){
            applyBean=applyService.getApplyByNoS(applyNo,staffNo);
        }else{
            applyBean=applyService.getApplyByNo(applyNo);
        }
        if(applyBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该申请单信息！").getMessage());
        }
        return applyBean;
    }

    @ApiOperation(value = "根据Type获取申请单", notes = "根据Type获取申请单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyType", value = "applyType", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "pageIndex", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/apply/applyType", method = RequestMethod.GET,produces = "application/json")
    public List<Apply> getApplyByType(@RequestParam("applyType")String applyType,@RequestParam("staffNo")Integer staffNo,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize){
        Staff staff = staffService.getStaffByNo(staffNo);
        System.out.println("pageIndex"+pageIndex);
        System.out.println("pageSize"+pageSize);
        if(staff.getStaffDuty().equals("普通员工")){
            return applyService.getApplyByTypeS(applyType,staffNo,pageIndex*pageSize,pageSize);
        }else{
            return applyService.getApplyByType(applyType,pageIndex*pageSize,pageSize);
        }
    }


    @ApiOperation(value = "根据Type获取申请单数量", notes = "根据Type获取申请单数量", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyType", value = "applyType", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "/apply/applyType/count", method = RequestMethod.GET,produces = "application/json")
    public Integer getApplyByType(@RequestParam("applyType")String applyType,@RequestParam("staffNo")Integer staffNo){
        Staff staff = staffService.getStaffByNo(staffNo);
        if(staff.getStaffDuty().equals("普通员工")){
            return applyService.getApplyByTypeCS(applyType,staffNo);
        }else{
            return applyService.getApplyByTypeC(applyType);
        }
    }

    @ApiOperation(value = "根据State获取申请单数量", notes = "根据State获取申请单数量", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyState", value = "applyState", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "/apply/applyState/count", method = RequestMethod.GET,produces = "application/json")
    public Integer getApplyByState(@RequestParam("applyState")String applyState,@RequestParam("staffNo")Integer staffNo){
        Staff staff = staffService.getStaffByNo(staffNo);
        if(staff.getStaffDuty().equals("普通员工")){
            return applyService.getApplyByStateCS(applyState,staffNo);
        }else{
            return applyService.getApplyByStateC(applyState);
        }
    }


    @ApiOperation(value = "根据State获取申请单", notes = "根据State获取申请单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyState", value = "applyState", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "pageIndex", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/apply/applyState", method = RequestMethod.GET,produces = "application/json")
    public List<Apply> getApplyByState(@RequestParam("applyState")String applyState,@RequestParam("staffNo")Integer staffNo,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize){
        Staff staff = staffService.getStaffByNo(staffNo);
        if(staff.getStaffDuty().equals("普通员工")){
            return applyService.getApplyByStateS(applyState,staffNo,pageIndex*pageSize,pageSize);
        }else{
            return applyService.getApplyByState(applyState,pageIndex*pageSize,pageSize);
        }
    }


    @ApiOperation(value = "添加申请单", notes = "添加申请单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "apply", value = "apply", dataType = "Apply", paramType = "body"),
    })
    @RequestMapping(value = "/apply", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertApply(@RequestBody Apply apply)
    {
        MessageBox messageBox=new MessageBox();
        try{
            apply.setApplyDate(new Date());
            String str="";
            for(int i=0;i<12;i++){
                char c = (char)((int)(Math.random()*10+48));
                str+=c;
            }
            apply.setApplyNo(str);
            applyService.insertApply(apply);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_APPLY_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_APPLY_SUCCESS_CODE);
        messageBox.setMessage(apply.getApplyNo());
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "更新申请单", notes = "更新申请单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "apply", value = "apply", dataType = "Apply", paramType = "body"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/apply", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateApply(@RequestParam("staffNo") Integer staffNo, @RequestBody Apply apply)
    {
        Apply applybean = applyService.getApplyByNo(apply.getApplyNo());
        MessageBox messageBox=new MessageBox();
        if(applybean.getApplyState().equals("已通过")){
            messageBox.setStatus(MessageBox.UPDATE_APPLY_FAILURE_CODE);
            messageBox.setMessage("订单已通过，不可修改");
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        Staff staff = staffService.getStaffByNo(staffNo);
        try{
            if(staff.getStaffDuty().equals("普通员工")){
                apply.setApplyDate(new Date());
                apply.setApplyStaffNo(staff.getStaffNo());
                applyService.updateApplyS(apply);
            }else{
                apply.setApplyUpdateDate(new Date());
/*                apply.setCheckStaffNo(staff.getStaffNo());*/
                applyService.updateApply(apply);
            }
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_APPLY_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_APPLY_SUCCESS_CODE);
        messageBox.setMessage("update apply success");
        logger.info(messageBox.getMessage()+apply.getApplyNo());
        return messageBox;
    }

    @ApiOperation(value = "删除申请单", notes = "删除申请单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/apply/{applyNo}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteApply(@PathVariable("applyNo") String applyNo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            applyService.deleteApply(applyNo);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_APPLY_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_APPLY_SUCCESS_CODE);
        messageBox.setMessage("delete apply success");
        logger.info(messageBox.getMessage()+applyNo);
        return messageBox;
    }

}
