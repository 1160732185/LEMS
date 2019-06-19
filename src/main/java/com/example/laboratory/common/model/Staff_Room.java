package com.example.laboratory.common.model;

public class Staff_Room {
    private Integer staffNo;
    private Integer roomNo;

    public Integer getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(Integer staffNo) {
        this.staffNo = staffNo;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Staff_Room{" +
                "staffNo=" + staffNo +
                ", roomNo=" + roomNo +
                '}';
    }
}
