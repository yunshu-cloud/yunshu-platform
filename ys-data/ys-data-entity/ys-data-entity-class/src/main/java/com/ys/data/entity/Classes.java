package com.ys.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Classes {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * class name
     */
    private String className;
    /**
     * class number
     */
    private Integer classNum;
    /**
     * create time
     */
    private Date createTime;
    /**
     * update time
     */
    private Date updateTime;
    /**
     * status
     */
    private Integer status;
    /**
     * delete flag 0-exist 1-delete
     */
    private Integer delFlag;
}
