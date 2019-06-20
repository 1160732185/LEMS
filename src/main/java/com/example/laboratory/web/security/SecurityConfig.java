package com.example.laboratory.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StaffAuthenticationSuccessHandler staffAuthenticationSuccessHandler;
    @Autowired
    private StaffAuthenticationFailHandler staffAuthenticationFailHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/v1/**",
                "/swagger-resources",
                "/configuration/security",
                "/swagger-resources",
                "/v2/api-docs",
                "/swagger-ui.html",
                "/webjars/**",
                "/swagger-resources/configuration/ui").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(staffAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(staffAuthenticationFailHandler);
        filter.setFilterProcessesUrl("/api/v1/login/form");
        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    @Bean
    public  StaffAuthenticationSuccessHandler getAuthenticationSuccessHandler()
    {
        return new StaffAuthenticationSuccessHandler();
    }

    @Bean
    public  StaffAuthenticationFailHandler getAuthenticationFailHandler()
    {
        return new StaffAuthenticationFailHandler();
    }
}
