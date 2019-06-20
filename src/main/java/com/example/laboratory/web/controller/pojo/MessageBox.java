package com.example.laboratory.web.controller.pojo;

public class MessageBox {
    final static public int UPDATE_STAFF_SUCCESS_CODE=1000;
    final static public int UPDATE_STAFF_FAILURE_CODE=1001;
    final static public int DELETE_STAFF_SUCCESS_CODE=1002;
    final static public int DELETE_STAFF_FAILURE_CODE=1003;
    final static public int INSERT_STAFF_SUCCESS_CODE=1004;
    final static public int INSERT_STAFF_FAILURE_CODE=1005;

    private int status;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
