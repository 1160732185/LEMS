package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.service.StaffService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("api/v1")
public class StaffController {
    @Autowired
    StaffService staffService;
    @ApiOperation(value = "获取员工列表", notes = "获取员工列表", produces = "application/json")
    @RequestMapping(value = "/staff", method = RequestMethod.GET,produces = "application/json")
    public List<Staff> getAllStaff() {
    return staffService.getAllStaff();
    }
}
