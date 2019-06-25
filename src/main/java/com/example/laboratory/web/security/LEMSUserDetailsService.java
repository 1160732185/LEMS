package com.example.laboratory.web.security;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LEMSUserDetailsService implements UserDetailsService {
    @Autowired
    StaffService staffService;
    private static final Logger log = LoggerFactory.getLogger(LEMSUserDetailsService.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Staff staffBean=getLoginUser(s);
        UserDetails ud = new org.springframework.security.core.userdetails.User(String.valueOf(staffBean.getStaffNo()),passwordEncoder.encode(staffBean.getStaffPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+staffBean.getStaffDuty()));
        return ud;
    }

    private Staff getLoginUser(String s)throws UsernameNotFoundException
    {
        Staff staffBean=null;
        int id=-1;
        int error = 0;
        if(s==null) return staffBean;
        System.out.println(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<48||s.charAt(i)>57) {
                log.info("用户名格式不匹配:"+s);
                throw new UsernameNotFoundException("用户名格式不匹配！");}
        }
            try {
                id = Integer.valueOf(s);
            } catch (NumberFormatException e) {
            }
            if (id != -1)
                staffBean = staffService.getStaffByNo(Integer.valueOf(s));
            if (staffBean == null) {
                if ((staffBean = staffService.getStaffByNo(Integer.valueOf(s))) == null)
                    log.info("找不到该账户信息:"+s);
                    throw new UsernameNotFoundException("找不到该账户信息！");
            }
            return staffBean;
    }
}
