package com.example.laboratory.web.controller;

import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Api(value = "AuthController", description = "用户认证服务")
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class LoginController {
    @Autowired
    MailService mailService;
    @ApiOperation(value = "登录服务提交数据", notes = "提交数据测试用", produces = "application/json")
    @ApiImplicitParams({
            /*@ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "body"),
            @ApiImplicitParam(name = "staffPassword", value = "staffPassword", dataType = "String", paramType = "body")*/
            @ApiImplicitParam(name = "logininfo", value = "Json", dataType = "String", paramType = "body"),
    })
    @RequestMapping(value = "/login/form",method = {RequestMethod.POST},produces = "application/json")
    public void loginForm(){
System.out.println("aaa");
    }

    @ApiOperation(value = "发送邮件", notes = "发送邮件", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "address", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "code", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/login/sendEmail",method = {RequestMethod.GET},produces = "application/json")
    public void SendEmail(@RequestParam String address, @RequestParam String code){
        mailService.sendSimpleMail(address,"509、514实验室管理系统找回密码确认邮件","你的验证码为"+code);
    }
}
