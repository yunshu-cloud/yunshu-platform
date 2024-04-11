package com.ys.commons.web.r;

import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * 快捷生成R对象的工具方法
 */
public class RUtils {

    /**
     * 生成表示成功的R对象
     * @param data
     * @return
     * @param <T>
     */
     public static<T> R create(T data){
         return new R(Codes.SUCC.getCode(), Codes.SUCC.getMsg(),data);
     }

    /**
     * 生成一个指定响应枚举的响应对象
     * @param codes
     * @return
     * @param <T>
     */
     public static<T> R create(Codes codes,T data){
         return new R(codes.getCode(), codes.getMsg(),data);
     }

    /**
     * 生成一个指定响应码的枚举对象，不携带任何数据
     * @param codes
     * @return
     * @param <T>
     */
     public static<T> R create(Codes codes){
         return new R(codes.getCode(), codes.getMsg(),null);
     }
}
