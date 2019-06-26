package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Firm;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.FirmService;
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
public class FirmController {
    @Autowired
    FirmService firmService;
    private static final Logger logger = LoggerFactory.getLogger(FirmController.class);

    @ApiOperation(value = "获取公司数量", notes = "获取公司数量", produces = "application/json")
    @RequestMapping(value = "/firm/count", method = RequestMethod.GET,produces = "application/json")
    public MessageBox getFirmSum() {
        MessageBox messageBox = new MessageBox();
        messageBox.setStatus(firmService.getFirmCount());
        messageBox.setMessage("total");
        return messageBox;
    }



    @ApiOperation(value = "获取生产公司列表", notes = "获取生产公司列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "pageIndex", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "/firm", method = RequestMethod.GET,produces = "application/json")
    public List<Firm> getAllFirm(@RequestParam Integer pageIndex,@RequestParam Integer pageSize) {
        Integer firstRow=pageIndex*pageSize;
        return firmService.getAllFirm(firstRow,pageSize);
    }


    @ApiOperation(value = "根据No获取生产公司", notes = "根据No获取生产公司", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "firmNo", value = "No", dataType = "Integer", paramType = "path"),
    })
    @RequestMapping(value = "/firm/{firmNo}", method = RequestMethod.GET,produces = "application/json")
    public Firm getFirm(@PathVariable("firmNo")Integer firmNo){
        Firm firmBean=null;
            firmBean=firmService.getFirmByNo(firmNo);
        if(firmBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该生产公司信息！").getMessage());
        }
        return firmBean;
    }

    @ApiOperation(value = "添加生产公司", notes = "添加生产公司", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "firm", value = "firm", dataType = "Firm", paramType = "body"),
    })
    @RequestMapping(value = "/firm", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertFirm(@RequestBody Firm firm)
    {
        MessageBox messageBox=new MessageBox();
        try{
            firm.setFirmAddDate(new Date());
            firmService.insertFirm(firm);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_FIRM_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_FIRM_SUCCESS_CODE);
        messageBox.setMessage("insert firm success"+firm.getFirmName());
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "更新生产公司", notes = "更新生产公司", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "firm", value = "firm", dataType = "Firm", paramType = "body"),
    })
    @RequestMapping(value = "/firm", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateFirm(@RequestBody Firm firm)
    {
        MessageBox messageBox=new MessageBox();
        try{
            firm.setFirmAddDate(new Date());
            firmService.updateFirm(firm);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_FIRM_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_FIRM_SUCCESS_CODE);
        messageBox.setMessage("update firm success");
        logger.info(messageBox.getMessage()+firm.getFirmName());
        return messageBox;
    }

    @ApiOperation(value = "删除生产公司", notes = "删除生产公司", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "firmNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/firm/{firmNo}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteUser(@PathVariable("firmNo") String firmNo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            firmService.deleteFirm(Integer.valueOf(firmNo));
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_FIRM_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_FIRM_SUCCESS_CODE);
        messageBox.setMessage("delete firm success");
        logger.info(messageBox.getMessage()+firmNo);
        return messageBox;
    }

}
