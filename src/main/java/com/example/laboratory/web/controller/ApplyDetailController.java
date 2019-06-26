package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.ApplyDetail;
import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.ApplyDetailService;
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
public class ApplyDetailController {
    @Autowired
    ApplyDetailService applyDetailService;
    @Autowired
    StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(ApplyDetailController.class);

    @ApiOperation(value = "获取申请表项数量", notes = "获取申请表项数量", produces = "application/json")
    @ApiImplicitParam(name = "applyNo", value = "applyNo", dataType = "String", paramType = "query")
    @RequestMapping(value = "/applyDetail/count", method = RequestMethod.GET,produces = "application/json")
    public MessageBox getApplyDetailSum(@RequestParam("applyNo") String applyNo) {
        MessageBox messageBox=new MessageBox();
        messageBox.setMessage("total");
        messageBox.setStatus(applyDetailService.getApplyDetailCountByApplyNo(applyNo));
        return messageBox;
    }



    @ApiOperation(value = "根据No获取申请表项列表", notes = "根据No获取申请表项列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "pageIndex", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "applyNo", value = "applyNo", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/applyDetail", method = RequestMethod.GET,produces = "application/json")
    public List<ApplyDetail> getAllApplyDetail(@RequestParam("applyNo")String applyNo,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize)
    {
        Integer firstRow=pageIndex*pageSize;
        return applyDetailService.getAllApplyDetailByApplyNo(applyNo,firstRow,pageSize);
    }


    @ApiOperation(value = "添加申请表项", notes = "添加申请表项", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyDetail", value = "applyDetail", dataType = "ApplyDetail", paramType = "body"),
    })
    @RequestMapping(value = "/applyDetail", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertApplyDetail(@RequestBody ApplyDetail applyDetail)
    {
        MessageBox messageBox=new MessageBox();
        try{
            applyDetailService.insertApplyDetail(applyDetail);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_APPLYDETAIL_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_APPLYDETAIL_SUCCESS_CODE);
        messageBox.setMessage("恭喜你喜提彩蛋！");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "更新申请表项", notes = "更新申请表项", produces = "application/json")
    @ApiImplicitParam(name = "applyDetail", value = "applyDetail", dataType = "ApplyDetail", paramType = "body")
    @RequestMapping(value = "/applyDetail", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateApplyDetail(@RequestBody ApplyDetail applyDetail)
    {
        MessageBox messageBox=new MessageBox();
        try{
                applyDetailService.updateApplyDetail(applyDetail);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_APPLYDETAIL_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_APPLYDETAIL_SUCCESS_CODE);
        messageBox.setMessage("update applyDetail success");
        return messageBox;
    }

    @ApiOperation(value = "删除申请表项", notes = "删除申请表项", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "applyNo", value = "applyNo", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "modelNo", value = "modelNo", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/applyDetail", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteApplyDetail(@RequestParam("applyNo") String applyNo,@RequestParam("modelNo") String modelNo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            applyDetailService.deleteApplyDetail(applyNo,modelNo);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_APPLYDETAIL_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_APPLYDETAIL_SUCCESS_CODE);
        messageBox.setMessage("delete applyDetail success"+applyNo+modelNo);
        return messageBox;
    }

}
