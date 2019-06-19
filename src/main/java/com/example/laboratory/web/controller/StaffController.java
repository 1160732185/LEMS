package com.example.laboratory.web.controller;

import com.example.laboratory.web.service.StaffService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api
@RestController
@RequestMapping("api/v1")
public class StaffController {
    @Autowired
    StaffService staffService;

}
