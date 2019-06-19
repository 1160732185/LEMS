package com.example.laboratory.web;

import com.example.laboratory.common.model.Room;
import com.example.laboratory.web.service.*;
import com.example.laboratory.web.serviceimpl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    StaffService getStaffService() { return new StaffServiceImpl(); }
    @Bean
    ApplyDetailService getApplyDetailService(){return new ApplyDetailServiceImpl(); }
    @Bean
    ApplyService getApplyService(){return new ApplyServiceImpl(); }
    @Bean
    DeviceService getDeviceService(){return new DeviceServiceImpl(); }
    @Bean
    DisuseService getDisuseService(){return new DisuseServiceImpl(); }
    @Bean
    FirmService getFirmService(){return  new FirmServiceImpl();}
    @Bean
    ModelService getModelService(){return new ModelServiceImpl();}
    @Bean
    RepairService getRepairService(){return new RepairServiceImpl();}
    @Bean
    RoomService getRoomService(){return new RoomServiceImpl();}
    @Bean
    Staff_RoomService  getStaff_RoomService(){return new  Staff_RoomServiceImpl();}

}
