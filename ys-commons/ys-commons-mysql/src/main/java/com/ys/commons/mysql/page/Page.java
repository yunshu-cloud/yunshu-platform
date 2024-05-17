package com.ys.commons.mysql.page;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页实体对象
 */
@Data
public class Page implements Serializable {
    private Integer pageNum; // 当前页
    private Integer pageSize; //每页显示的条数
    private Integer pageCount; // 总条数
    private Integer pageTotal; // 总页码
}
