package com.ys.data.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Long id;
    private String name;
    private Object age;
    private String email;
    private Object birthday;
    private Object sex;
    private Date createTime;
    private Date updateTime;
    private Object delFlag;
}
