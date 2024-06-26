package com.ys.business.student.controller;

import com.ys.business.student.input.StudentInput;
import com.ys.business.student.service.StudentService;
import com.ys.commons.web.apiversion.ApiVersion;
import com.ys.commons.web.r.R;
import com.ys.commons.web.r.RUtils;
import com.ys.data.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/stu")
@Slf4j
@Validated
@ApiVersion(2.0)
@RefreshScope
public class StuController {
    @Autowired
    private StudentService studentService;

    @Value("${ys.name}")
    private String name;

    @Value("${multi.file}")
    private String multiFileConfig;

//    @RequestMapping("/list")
//    @ApiVersion(1.0)
//    public R list(){
//        log.info("[stu-list] 学生列表:");
//        // 手动设置分页对象
//        List<Student> stus = studentService.list();
//        return RUtils.create("stu - list - 1.0");
//    }


    @ApiVersion(2.0)
    @RequestMapping("/list")
    public R list2(){
        log.info("[stu-list] 学生列表 - 读取远程的配置信息 ：" + name);
        log.info("muti-file :" + multiFileConfig);
        // 手动设置分页对象
        List<Student> stus = studentService.list();
        return RUtils.create("stus - list - 2.0");
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
