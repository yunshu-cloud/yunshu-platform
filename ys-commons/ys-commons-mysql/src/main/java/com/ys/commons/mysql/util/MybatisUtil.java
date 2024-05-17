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

    /**
     * 返回sql语句中主表from的index位置
     * @param beginIndex 查找from的起始位置
     * @param sql sql语句
     * @return 主表from的index位置
     */
    public static int getMasterFrom(int beginIndex, String sql){
        if (sql == null){
            return -1;
        }

        int fromIndex = sql.indexOf(" from ", beginIndex);
        if (fromIndex == -1){
            return -1;
        }
        String sqlSub = sql.substring(0, fromIndex);

        int count = 0;
        char[] chars = sqlSub.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            if (c == '('){
                count ++;
            }
            if (c == ')'){
                count --;
            }
        }
        if (count == 0){
            return fromIndex;
        }else{
            return getMasterFrom(fromIndex + 6, sql);
        }
    }

}
