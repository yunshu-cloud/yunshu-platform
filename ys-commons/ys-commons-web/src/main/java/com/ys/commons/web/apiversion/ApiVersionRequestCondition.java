package com.ys.commons.web.apiversion;

import lombok.Getter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * 多版本接口的请求条件对象
 */
@Getter
public class ApiVersionRequestCondition implements RequestCondition<ApiVersionRequestCondition> {

    // 表示当前版本号
    private double apiVersion = 1.0;


    // 通过构造方法设置
    public ApiVersionRequestCondition(double apiVersion){
        this.apiVersion = apiVersion;
    }

    private static final String VERSION_NAME="api-version";

    @Override
    public ApiVersionRequestCondition combine(ApiVersionRequestCondition other) {
        // this代表Controller的请求条件
        // other 代表Controller中某个方法的请求条件

        return other;
    }

    /**
     * 根据请求判断当前RequestCondition对象是否匹配请求
     * 匹配规则
     * @param request
     * @return
     */
    @Override
    public ApiVersionRequestCondition getMatchingCondition(HttpServletRequest request) {
        double reqVersionDouble = 1.0;

        // 获取请求中的版本信息， 如果没有 默认请求版本1.0
        String reqVersion = request.getHeader(VERSION_NAME);
        if (StringUtils.isEmpty(reqVersion)){
            // 从参数中获取
            reqVersion = request.getParameter(VERSION_NAME);
        }

        // 不为空 将string转换为double
        if(!StringUtils.isEmpty(reqVersion)){
            try {
                reqVersionDouble = Double.parseDouble(reqVersion);
            } catch (Throwable t){
                reqVersionDouble = 1.0;
            }
        }

        // 想上兼容
        if (this.getApiVersion() <= reqVersionDouble){
            // 当前方法或者是类 已经匹配了当前的请求 返回条件本身
            return this;
        }
        // 说明没有匹配 则返回空 ， 那么这个条件对应的方法就不符合请求的版本要求
        return null;
    }

    /**
     * 排序 - 为了选择最优的条件进行排序
     * @param other
     * @param request
     * @return
     */
    @Override
    public int compareTo(ApiVersionRequestCondition other, HttpServletRequest request) {
        // 降序排列 让版本号更大的接口排在前面
        return Double.compare(other.getApiVersion(), this.getApiVersion());
    }
}
