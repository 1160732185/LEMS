package com.example.laboratory.web.controller;

import com.example.laboratory.common.model.Room;
import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.RoomService;
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
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @ApiOperation(value = "获取房间数量", notes = "获取房间数量", produces = "application/json")
    @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    @RequestMapping(value = "/room/count", method = RequestMethod.GET,produces = "application/json")
    public MessageBox getRoomSum(@RequestParam("staffNo") Integer staffNo) {
        Staff staff = staffService.getStaffByNo(staffNo);
        MessageBox messageBox = new MessageBox();
        if(staff.getStaffDuty().equals("普通员工")) {
            messageBox.setMessage("total");
            messageBox.setStatus(roomService.getRoomCountS(staffNo));
        }else {
            messageBox.setStatus(roomService.getRoomCount());
            messageBox.setMessage("total");
        }
        return messageBox;
    }


    @ApiOperation(value = "获取房间列表", notes = "获取房间列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "pageIndex", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/room", method = RequestMethod.GET,produces = "application/json")
    public List<Room> getAllRoom(@RequestParam("staffNo")Integer staffNo,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize) {
        Staff staff = staffService.getStaffByNo(staffNo);
        logger.info(staffNo+"正在查看房间列表");
        Integer firstRow=pageIndex*pageSize;
        if(staff.getStaffDuty().equals("普通员工")) {
            return roomService.getAllRoomS(staffNo,firstRow,pageSize);
        }
        return roomService.getAllRoom(firstRow,pageSize);
    }


    @ApiOperation(value = "根据No获取房间", notes = "根据No获取房间", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roomNo", value = "roomNo", dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "staffNo", value = "staffNo", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/room/{roomNo}", method = RequestMethod.GET,produces = "application/json")
    public Room getRoomByNo(@PathVariable("roomNo")Integer roomNo,@RequestParam("staffNo")Integer staffNo){
        Staff staff = staffService.getStaffByNo(staffNo);
        Room roomBean=null;
        if(staff.getStaffDuty().equals("普通员工")){
            roomBean=roomService.getRoomByNoS(roomNo,staffNo);
        }else{
            roomBean=roomService.getRoomByNo(roomNo);
        }
        if(roomBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该房间信息！").getMessage());
        }
        return roomBean;
    }

    @ApiOperation(value = "添加房间", notes = "添加房间", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "room", value = "room", dataType = "Room", paramType = "body"),
    })
    @RequestMapping(value = "/room", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertRoom(@RequestBody Room room)
    {
        MessageBox messageBox=new MessageBox();
        try{
            room.setRoomAddDate(new Date());
            roomService.insertRoom(room);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_ROOM_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_ROOM_SUCCESS_CODE);
        messageBox.setMessage("insert room success"+room.getRoomName());
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "更新房间", notes = "更新房间", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "room", value = "room", dataType = "Room", paramType = "body"),
    })
    @RequestMapping(value = "/room", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateRoom(@RequestBody Room room)
    {
        MessageBox messageBox=new MessageBox();
        try{
            room.setRoomAddDate(new Date());
            roomService.updateRoom(room);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_ROOM_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_ROOM_SUCCESS_CODE);
        messageBox.setMessage("update room success");
        logger.info(messageBox.getMessage()+room.getRoomName());
        return messageBox;
    }

    @ApiOperation(value = "删除房间", notes = "删除房间", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roomNo", value = "No", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/room/{roomNo}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteRoom(@PathVariable("roomNo") String roomNo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            roomService.deleteRoom(Integer.valueOf(roomNo));
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_ROOM_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_ROOM_SUCCESS_CODE);
        messageBox.setMessage("delete room success");
        logger.info(messageBox.getMessage()+roomNo);
        return messageBox;
    }

}
