package com.sda.spring.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder){
        
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/web/roleform").hasAuthority("admin")
                .anyRequest()
                .authenticated().and().formLogin().loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/web/roleform")
                .usernameParameter("address")
                .passwordParameter("password");
    }
}
