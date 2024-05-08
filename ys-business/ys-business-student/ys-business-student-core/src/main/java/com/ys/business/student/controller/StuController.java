package com.ys.business.student.controller;

import com.ys.business.student.input.StudentInput;
import com.ys.business.student.service.StudentService;
import com.ys.commons.web.r.R;
import com.ys.commons.web.r.RUtils;
import com.ys.data.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/stu")
@Slf4j
@Validated
public class StuController {
    @Autowired
    private StudentService studentService;


    @RequestMapping("/list")
    public R list(){
        log.info("[stu-list] 学生列表:");
        List<Student> stus = studentService.list();
        return RUtils.create(stus);
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
    public R insert(@Valid StudentInput stu){
        log.info("[stu-insert] 学生添加，{}",stu);

        Student student = new Student();
        BeanUtils.copyProperties(stu, student);

        // 调用业务层
        boolean flag = studentService.save(student);
        return  RUtils.create(flag);
    }
}
