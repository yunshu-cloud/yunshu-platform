package com.ys.commons.mysql.plugin;

import com.ys.commons.mysql.util.MybatisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Statement;

/**
 * SQL监控记录插件
 */
@Intercepts(
        @Signature(
                type = StatementHandler.class,
                method = "query",
                args = {Statement.class, ResultHandler.class}
        )
)
@Slf4j
public class SQLPlugin implements Interceptor {

    /**
     * 核心的拦截方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 记录当前执行的sql语句 & 记录sql语句执行的耗时
        StatementHandler statementHandler = (StatementHandler) MybatisUtil.getNoProxyObject(invocation.getTarget());
        String sql = statementHandler.getBoundSql().getSql(); // 获取sql语句

        log.info("[SQL - EXEC]: 执行SQL语句：{}",sql);

        long begin = System.currentTimeMillis();
        Object result = invocation.proceed();
        long end = System.currentTimeMillis();

        log.info("[SQL - EXEC] SQL的耗时：{}s", BigDecimal.valueOf(end).subtract(BigDecimal.valueOf(begin))
                .divide(BigDecimal.valueOf(1000)).setScale(6, RoundingMode.DOWN));
        return result;
    }
}
