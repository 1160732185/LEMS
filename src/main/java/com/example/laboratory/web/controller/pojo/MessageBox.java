package com.example.laboratory.web.controller.pojo;

public class MessageBox {
    // 登录状态码
    final static public int LOGIN_SUCCESS_CODE=1000;
    final static public int LOGIN_FAILURE_CODE=1001;
    final static public int LOGOUT_SUCCESS_CODE=1002;
    final static public int LOGOUT_ERROR_CODE=1003;
    final static public int NOT_LOGIN_CODE=1005;

    // 员工状态码
    final static public int UPDATE_STAFF_SUCCESS_CODE=2000;
    final static public int UPDATE_STAFF_FAILURE_CODE=2001;
    final static public int DELETE_STAFF_SUCCESS_CODE=2002;
    final static public int DELETE_STAFF_FAILURE_CODE=2003;
    final static public int INSERT_STAFF_SUCCESS_CODE=2004;
    final static public int INSERT_STAFF_FAILURE_CODE=2005;

    // 员工-房间状态码
    final static public int UPDATE_STAFF_ROOM_SUCCESS_CODE=2500;
    final static public int UPDATE_STAFF_ROOM_FAILURE_CODE=2501;
    final static public int DELETE_STAFF_ROOM_SUCCESS_CODE=2502;
    final static public int DELETE_STAFF_ROOM_FAILURE_CODE=2503;
    final static public int INSERT_STAFF_ROOM_SUCCESS_CODE=2504;
    final static public int INSERT_STAFF_ROOM_FAILURE_CODE=2505;

    // 房间状态码
    final static public int UPDATE_ROOM_SUCCESS_CODE=3000;
    final static public int UPDATE_ROOM_FAILURE_CODE=3001;
    final static public int DELETE_ROOM_SUCCESS_CODE=3002;
    final static public int DELETE_ROOM_FAILURE_CODE=3003;
    final static public int INSERT_ROOM_SUCCESS_CODE=3004;
    final static public int INSERT_ROOM_FAILURE_CODE=3005;

    // 型号状态码
    final static public int UPDATE_MODEL_SUCCESS_CODE=4000;
    final static public int UPDATE_MODEL_FAILURE_CODE=4001;
    final static public int DELETE_MODEL_SUCCESS_CODE=4002;
    final static public int DELETE_MODEL_FAILURE_CODE=4003;
    final static public int INSERT_MODEL_SUCCESS_CODE=4004;
    final static public int INSERT_MODEL_FAILURE_CODE=4005;

    // 厂商状态码
    final static public int UPDATE_FIRM_SUCCESS_CODE=5000;
    final static public int UPDATE_FIRM_FAILURE_CODE=5001;
    final static public int DELETE_FIRM_SUCCESS_CODE=5002;
    final static public int DELETE_FIRM_FAILURE_CODE=5003;
    final static public int INSERT_FIRM_SUCCESS_CODE=5004;
    final static public int INSERT_FIRM_FAILURE_CODE=5005;

    // 设备状态码
    final static public int UPDATE_DEVICE_SUCCESS_CODE=6000;
    final static public int UPDATE_DEVICE_FAILURE_CODE=6001;
    final static public int DELETE_DEVICE_SUCCESS_CODE=6002;
    final static public int DELETE_DEVICE_FAILURE_CODE=6003;
    final static public int INSERT_DEVICE_SUCCESS_CODE=6004;
    final static public int INSERT_DEVICE_FAILURE_CODE=6005;

    // 申请单状态码
    final static public int UPDATE_APPLY_SUCCESS_CODE=7000;
    final static public int UPDATE_APPLY_FAILURE_CODE=7001;
    final static public int DELETE_APPLY_SUCCESS_CODE=7002;
    final static public int DELETE_APPLY_FAILURE_CODE=7003;
    final static public int INSERT_APPLY_SUCCESS_CODE=7004;
    final static public int INSERT_APPLY_FAILURE_CODE=7005;

    // 申请单详情状态码
    final static public int UPDATE_APPLYDETAIL_SUCCESS_CODE=7100;
    final static public int UPDATE_APPLYDETAIL_FAILURE_CODE=7101;
    final static public int DELETE_APPLYDETAIL_SUCCESS_CODE=7102;
    final static public int DELETE_APPLYDETAIL_FAILURE_CODE=7103;
    final static public int INSERT_APPLYDETAIL_SUCCESS_CODE=7104;
    final static public int INSERT_APPLYDETAIL_FAILURE_CODE=7105;

    // 报修记录状态码
    final static public int UPDATE_REPAIR_SUCCESS_CODE=8000;
    final static public int UPDATE_REPAIR_FAILURE_CODE=8001;
    final static public int DELETE_REPAIR_SUCCESS_CODE=8002;
    final static public int DELETE_REPAIR_FAILURE_CODE=8003;
    final static public int INSERT_REPAIR_SUCCESS_CODE=8004;
    final static public int INSERT_REPAIR_FAILURE_CODE=8005;

    // 报废记录状态码
    final static public int UPDATE_DISUSE_SUCCESS_CODE=9000;
    final static public int UPDATE_DISUSE_FAILURE_CODE=9001;
    final static public int DELETE_DISUSE_SUCCESS_CODE=9002;
    final static public int DELETE_DISUSE_FAILURE_CODE=9003;
    final static public int INSERT_DISUSE_SUCCESS_CODE=9004;
    final static public int INSERT_DISUSE_FAILURE_CODE=9005;



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
