package com.example.laboratory.web.security;

import com.example.laboratory.common.model.Staff;
import com.example.laboratory.web.service.StaffService;
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

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Staff staffBean=getLoginUser(s);

        return new org.springframework.security.core.userdetails.User(String.valueOf(staffBean.getStaffNo()),passwordEncoder.encode(staffBean.getStaffPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList(staffBean.getStaffDuty()));
    }

    private Staff getLoginUser(String s)throws UsernameNotFoundException
    {
        int id=-1;
        try{
            id=Integer.valueOf(s);
        } catch (NumberFormatException e)
        {

        }
        Staff staffBean=null;
        if(id!=-1)
            staffBean=staffService.getStaffByNo(Integer.valueOf(s));
        if(staffBean==null)
        {
                    if((staffBean=staffService.getStaffByNo(Integer.valueOf(s)))==null)
                        throw new UsernameNotFoundException("找不到该账户信息！");
        }
        return staffBean;
    }
}
