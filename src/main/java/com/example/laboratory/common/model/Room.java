package com.example.laboratory.common.model;

import java.util.Date;

public class Room {
    private Integer roomNo;
    private String roomName;
    private String roomType;
    private String roomState;
    private String roomAddress;
    private Date roomAddDate;

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomState() {
        return roomState;
    }

    public void setRoomState(String roomState) {
        this.roomState = roomState;
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress;
    }

    public Date getRoomAddDate() {
        return roomAddDate;
    }

    public void setRoomAddDate(Date roomAddDate) {
        this.roomAddDate = roomAddDate;
    }
}
