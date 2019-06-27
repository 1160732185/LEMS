package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Repair;
import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.RepairService;
import com.example.laboratory.web.service.StaffService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

@Api
@RestController
@RequestMapping("api/v1")
public class RepairController {
    @Autowired
    RepairService repairService;
    @Autowired
    StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(RepairController.class);

    @ApiOperation(value = "获取报修单数量", notes = "获取报修单数量", produces = "application/json")
    @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    @RequestMapping(value = "/repair/count", method = RequestMethod.GET,produces = "application/json")
    public MessageBox getRepairSum(@RequestParam("staffNo") Integer staffNo) {
        MessageBox messageBox=new MessageBox();
        Staff staff = staffService.getStaffByNo(staffNo);
        if(staff.getStaffDuty().equals("普通员工")) {
            messageBox.setMessage("total");
            messageBox.setStatus(repairService.getRepairCountS(staffNo));
            return messageBox;
        }
        messageBox.setMessage("total");
        messageBox.setStatus(repairService.getRepairCount());
        return messageBox;
    }



    @ApiOperation(value = "获取报修单列表", notes = "获取报修单列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "pageIndex", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/repair", method = RequestMethod.GET,produces = "application/json")
    public List<Repair> getAllRepair(@RequestParam("staffNo")Integer staffNo,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize) {
        Staff staff = staffService.getStaffByNo(staffNo);
        Integer firstRow=pageIndex*pageSize;
        if(staff.getStaffDuty().equals("普通员工")) {
            return repairService.getAllRepairS(staffNo,firstRow,pageSize);
        }
        return repairService.getAllRepair(firstRow,pageSize);
    }


    @ApiOperation(value = "根据No获取报修单", notes = "根据No获取报修单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "repairNo", value = "repairNo", dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/repair/{repairNo}", method = RequestMethod.GET,produces = "application/json")
    public Repair getRepair(@PathVariable("repairNo")Integer repairNo,@RequestParam("staffNo")Integer staffNo){
        Staff staff = staffService.getStaffByNo(staffNo);
        Repair repairBean=null;
        if(staff.getStaffDuty().equals("普通员工")){
            repairBean=repairService.getRepairByNoS(repairNo,staffNo);
        }else{
            repairBean=repairService.getRepairByNo(repairNo);
        }
        if(repairBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该报修单信息！").getMessage());
        }
        return repairBean;
    }

    @ApiOperation(value = "根据deviceNo获取报修单", notes = "根据deviceNo获取报修单", produces = "application/json")
    @ApiImplicitParam(name = "deviceNo", value = "diviceNo", dataType = "String", paramType = "path")
    @RequestMapping(value = "/repair/deviceNo/{deviceNo}", method = RequestMethod.GET,produces = "application/json")
    public Repair getDisuseByDeviceNo(@PathVariable("deviceNo")String deviceNo){
        Repair repairBean=repairService.getRepairByDevice(deviceNo);
        if(repairBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该报修单信息！").getMessage());
        }
        return repairBean;
    }

    @ApiOperation(value = "添加报修单", notes = "添加报修单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "repair", value = "repair", dataType = "Repair", paramType = "body"),
    })
    @RequestMapping(value = "/repair", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertRepair(@RequestBody Repair repair)
    {
        MessageBox messageBox=new MessageBox();
        try{
            repair.setRepairDate(new Date());
            String str="R";
            for(int i=0;i<11;i++){
                str += (char)((int)(Math.random()*10+48));;
            }
            repair.setRepairNo(str);
            repairService.insertRepair(repair);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_REPAIR_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_REPAIR_SUCCESS_CODE);
        messageBox.setMessage(repair.getRepairNo());
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "更新报修单", notes = "更新报修单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "repair", value = "repair", dataType = "Repair", paramType = "body"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/repair", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateRepair(@RequestParam("staffNo") Integer staffNo, @RequestBody Repair repair)
    {
        MessageBox messageBox=new MessageBox();
        Staff staff = staffService.getStaffByNo(staffNo);
        if(repair.getRepairResult()!=null){
            messageBox.setStatus(MessageBox.UPDATE_REPAIR_FAILURE_CODE);
            messageBox.setMessage("订单已修理完毕");
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        try{
            if(staff.getStaffDuty().equals("普通员工")&&repair.getStaffNo()!=staff.getStaffNo()){
                messageBox.setStatus(MessageBox.UPDATE_REPAIR_FAILURE_CODE);
                messageBox.setMessage("无权限更新");
                logger.error(messageBox.getMessage());
                return messageBox;
            }else{
                if(repair.getRepairResult()!=null){
                    repair.setRepairFinishDate(new Date());
                }
                repairService.updateRepair(repair);
            }
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_REPAIR_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_REPAIR_SUCCESS_CODE);
        messageBox.setMessage("update repair success");
        logger.info(messageBox.getMessage()+repair.getRepairNo());
        return messageBox;
    }

    @ApiOperation(value = "删除报修单", notes = "删除报修单", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "repairNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/repair/{repairNo}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteUser(@PathVariable("repairNo") String repairNo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            repairService.deleteRepair(Integer.valueOf(repairNo));
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_REPAIR_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_REPAIR_SUCCESS_CODE);
        messageBox.setMessage("delete repair success");
        logger.info(messageBox.getMessage()+repairNo);
        return messageBox;
    }

}
