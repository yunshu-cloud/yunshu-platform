package com.ys.commons.mysql.webinterceptor;


import com.ys.commons.mysql.page.YunshuPage;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class PageInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {

        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");

        if (pageNum != null && pageSize != null){
            try {
                Integer pNum = Integer.parseInt(pageNum);
                Integer pSize = Integer.parseInt(pageSize);

                // 设置分页参数
                YunshuPage.setPage(pNum, pSize);
            } catch (Throwable e){
                return true;
            }
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清空ThreadLocal
        YunshuPage.clear();
    }
}
