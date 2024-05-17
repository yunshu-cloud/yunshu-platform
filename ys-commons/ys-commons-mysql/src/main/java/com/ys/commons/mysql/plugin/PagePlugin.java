package com.ys.commons.mysql.plugin;

import com.ys.commons.mysql.page.Page;
import com.ys.commons.mysql.page.YunshuPage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;

/**
 * 自定义mybatis分页插件
 */
@Intercepts(
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )
)
@Slf4j
public class PagePlugin implements Interceptor {

    /**
     * 拦截的是MyBatis的Statement准备方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取statementHandler
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();

        //获取拦截的sql语句
        String sql = statementHandler.getBoundSql().getSql().toLowerCase().replaceAll("\n", "");
        //判断当前是否为查询sql
        if (!sql.startsWith("select")){ // 非查询语句直接放行
            return invocation.proceed();
        }

        // the current sql is select type
        Page page = YunshuPage.getPage();
        if (page == null){
            return invocation.proceed();
        }

        // 开始分页 -- select * from student limit ?,?
        log.info("[page - plugin] 开始分页 - {}", sql);
        // 计算出总条数
        getCount(sql);


        return null;
    }


    /**
     * 计算查询的总条数
     * @return
     */
    private Integer getCount(String sql){
        String countSql = "select count(*) " + sql.substring(sql.indexOf("from"));
        log.info("[page - plugin] 生成记录总条数的sql语句 - {}",countSql);

        return 0;
    }
}
