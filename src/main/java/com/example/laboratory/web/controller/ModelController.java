package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Model;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.ModelService;
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
public class ModelController {
    @Autowired
    ModelService modelService;
    private static final Logger logger = LoggerFactory.getLogger(ModelController.class);

    @ApiOperation(value = "获取产品数量", notes = "获取产品数量", produces = "application/json")
    @RequestMapping(value = "/model/count", method = RequestMethod.GET,produces = "application/json")
    public MessageBox getModelSum() {
        MessageBox messageBox = new MessageBox();
        messageBox.setStatus(modelService.getModelCount());
        messageBox.setMessage("total");
        return messageBox;
    }



    @ApiOperation(value = "获取产品型号列表", notes = "获取产品型号列表", produces = "application/json")
    @RequestMapping(value = "/model", method = RequestMethod.GET,produces = "application/json")
    public List<Model> getAllModel() {
        return modelService.getAllModel();
    }


    @ApiOperation(value = "根据No获取产品型号", notes = "根据No获取产品型号", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "modelNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/model/{modelNo}", method = RequestMethod.GET,produces = "application/json")
    public Model getModel(@PathVariable("modelNo")String modelNo){
        Model modelBean=null;
        modelBean=modelService.getModelByNo(modelNo);
        if(modelBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该产品型号信息！").getMessage());
        }
        return modelBean;
    }

    @ApiOperation(value = "添加产品型号", notes = "添加产品型号", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "model", value = "model", dataType = "Model", paramType = "body"),
    })
    @RequestMapping(value = "/model", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertModel(@RequestBody Model model)
    {
        MessageBox messageBox=new MessageBox();
        try{
            modelService.insertModel(model);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_MODEL_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_MODEL_SUCCESS_CODE);
        messageBox.setMessage("insert model success"+model.getModelName());
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "更新产品型号", notes = "更新产品型号", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "model", value = "model", dataType = "Model", paramType = "body"),
    })
    @RequestMapping(value = "/model", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateModel(@RequestBody Model model)
    {
        MessageBox messageBox=new MessageBox();
        try{
            modelService.updateModel(model);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_MODEL_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_MODEL_SUCCESS_CODE);
        messageBox.setMessage("update model success");
        logger.info(messageBox.getMessage()+model.getModelName());
        return messageBox;
    }

    @ApiOperation(value = "删除产品型号", notes = "删除产品型号", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "modelNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/model/{modelNo}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteUser(@PathVariable("modelNo") String modelNo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            modelService.deleteModel(modelNo);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_MODEL_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_MODEL_SUCCESS_CODE);
        messageBox.setMessage("delete model success");
        logger.info(messageBox.getMessage()+modelNo);
        return messageBox;
    }

}
