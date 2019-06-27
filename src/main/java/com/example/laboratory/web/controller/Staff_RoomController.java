package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.common.model.Staff_Room;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.Staff_RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Api
@RestController
@RequestMapping("api/v1")
public class Staff_RoomController {
@Autowired
    Staff_RoomService staff_roomService;
    @ApiOperation(value = "添加员工-房间", notes = "添加员工-房间", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "roomNo", value = "roomNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/staff_room", method = RequestMethod.POST, produces = "application/json")
    public MessageBox insertStaff(@RequestParam("staffNo") Integer staffNo, @RequestParam("roomNo") Integer roomNo) {
        MessageBox messageBox = new MessageBox();
        System.out.println("staff"+staffNo);
        System.out.println("room"+roomNo);
        staff_roomService.insertStaff(staffNo,roomNo);
        messageBox.setStatus(MessageBox.INSERT_STAFF_ROOM_SUCCESS_CODE);
        messageBox.setMessage("insert staff_room success");
        return messageBox;
    }

    @ApiOperation(value = "通过员工查看房间", notes = "通过员工查看房间", produces = "application/json")
    @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    @RequestMapping(value = "/staff_room/staffNo", method = RequestMethod.GET, produces = "application/json")
    public List<Staff_Room> getStaffRoomByStaffNo(@RequestParam("staffNo") Integer staffNo) {
        return staff_roomService.getStaffRoomByStaffNo(staffNo);
    }

    @ApiOperation(value = "通过房间查看员工", notes = "通过房间查看员工", produces = "application/json")
    @ApiImplicitParam(name = "roomNo", value = "roomNo", dataType = "Integer", paramType = "query")
    @RequestMapping(value = "/staff_room/roomNo", method = RequestMethod.GET, produces = "application/json")
    public List<Staff>  getStaffRoomByRoomNo(@RequestParam("roomNo") Integer roomNo) {
        System.out.println("roomNo"+roomNo);
        return staff_roomService.getStaffRoomByRoomNo(roomNo);
    }

}
