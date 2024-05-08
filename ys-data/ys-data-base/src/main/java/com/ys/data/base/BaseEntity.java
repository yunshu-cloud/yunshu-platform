package com.ys.data.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private Date createTime = new Date();
    private Date updateTime = new Date();
    private Integer status = 0;
    private Integer delFlag = 0;
}
