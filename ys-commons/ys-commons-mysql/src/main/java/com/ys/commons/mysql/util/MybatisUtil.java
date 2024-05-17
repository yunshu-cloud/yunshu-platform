package com.ys.commons.mysql.util;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

public class MybatisUtil {

    /**
     * 获取非代理的内置属性
     * @param target
     * @return
     */
    public static Object getNoProxyObject(Object target){
        MetaObject metaObject = SystemMetaObject.forObject(target);
        if (metaObject.hasGetter("h")){
            // is proxy object
            target = metaObject.getValue("h.target");
            metaObject = SystemMetaObject.forObject(target);
        }
        return target;
    }
}
