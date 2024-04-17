package com.ys.business.student.controller;

import com.ys.business.student.input.StudentInput;
import com.ys.commons.web.r.R;
import com.ys.commons.web.r.RUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/stu")
@Slf4j
@Validated
public class StuController {

    @Value("${spring.datasource.url}")
    private String datasource;


    @RequestMapping("/list")
    public R list(){
        System.out.println(datasource);
        log.info("log records");
        System.out.println(1/0);
        return RUtils.create("学生列表");
    }

    @RequestMapping("/login")
    public R login(@NotBlank(message = "用户名不能为空") String username,
                   @NotBlank(message = "密码不能为空") String password){
        log.info("[stu-login] 学生登录：登录名：{},密码:{}",username,password);
        return RUtils.create("登录成功！");
    }

    /**
     * 添加学生
     * @return
     */
    @RequestMapping("/insert")
    public R insert(@Valid @RequestBody StudentInput student){
        log.info("[stu-insert] 学生添加，{}",student);
        // 调用业务层
        return  RUtils.create("添加成功");
    }
}
