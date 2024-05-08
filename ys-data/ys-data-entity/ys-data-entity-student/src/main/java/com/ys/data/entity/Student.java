package com.ys.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Student {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date birthday;
    private Integer sex;
    private Date createTime = new Date();
    private Date updateTime = new Date();
    private Integer status;
    private Integer delFlag;
}
