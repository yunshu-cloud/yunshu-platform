package com.ys.business.student.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
@Slf4j
public class StuController {

    @Value("${spring.datasource.url}")
    private String datasource;


    @RequestMapping("/list")
    public String list(){
        System.out.println(datasource);
        log.info("log records");
        return "stu list";
    }

    @RequestMapping("/login")
    public String login(String username, String password){
        log.info("[stu-login] 学生登录：登录名：{},密码:{}",username,password);
        return "登录成功！";
    }
}
