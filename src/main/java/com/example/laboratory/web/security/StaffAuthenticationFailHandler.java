package com.example.laboratory.web.security;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.controller.pojo.MessageBox;
import com.example.laboratory.web.service.StaffService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class StaffAuthenticationFailHandler implements AuthenticationFailureHandler {
    private static final Logger log = LoggerFactory.getLogger(StaffAuthenticationFailHandler.class);

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        log.info("登录失败");
        log.info("exception message" + exception.getMessage());
        Map<String, Object> map = new HashMap<>();
        MessageBox message=new MessageBox();
        message.setStatus(MessageBox.LOGIN_FAILURE_CODE);
        message.setMessage("Load Failure");
        map.put("message",message);
        map.put("data",exception.getMessage());
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().write(objectMapper.writeValueAsString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
