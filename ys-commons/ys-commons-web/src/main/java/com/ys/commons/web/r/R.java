package com.ys.commons.web.r;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {
    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;
}
