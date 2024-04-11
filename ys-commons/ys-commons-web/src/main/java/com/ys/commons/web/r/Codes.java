package com.ys.commons.web.r;

import lombok.Getter;

/**
 * 接口响应的响应码 枚举类
 */
@Getter
public enum Codes {

    SUCC(200, "成功"),
    FAIL(500,"服务器异常");

     private Integer code;
     private String msg;

     Codes(Integer code, String msg){
         this.code = code;
         this.msg = msg;
     }
}
