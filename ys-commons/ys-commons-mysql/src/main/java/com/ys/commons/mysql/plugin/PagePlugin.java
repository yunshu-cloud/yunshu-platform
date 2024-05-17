package com.ys.commons.mysql.plugin;

import com.ys.commons.mysql.page.Page;
import com.ys.commons.mysql.page.YunshuPage;
import com.ys.commons.mysql.util.MybatisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        StatementHandler statementHandler = (StatementHandler) MybatisUtil.getNoProxyObject(invocation.getTarget());

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
        Integer count = getCount(invocation, sql, statementHandler);

        if (page.getPageSize() == null){
            page.setPageSize(10);
        }

        // 设置总条数
        page.setPageCount(count);
        // 设置总页码
        page.setPageTotal(page.getPageCount() % page.getPageSize() == 0 ? page.getPageCount() / page.getPageSize() : page.getPageCount() / page.getPageSize() + 1);

        // 判断页码的临界值
        if (page.getPageNum() < 1){
            page.setPageNum(1);
        }
        if (page.getPageNum() > page.getPageTotal()){
            page.setPageNum(page.getPageTotal());
        }

        // 开始进行分页 选择策略模式 - 根据不同的数据库 选择不同的分页模式
        sql += " limit " + (page.getPageNum() - 1) * page.getPageSize() + "," + page.getPageSize();
        log.info("[page -plugin] 生成分页的sql语句 - {}", sql);

        // 将修改后的sql替换掉原来的sql
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler.getBoundSql());
        metaObject.setValue("sql",sql);

        log.info("[page - plugin] 分页完成");
        // 放行
        return invocation.proceed();
    }


    /**
     * 计算查询的总条数
     * @return
     */
    private Integer getCount(Invocation invocation, String sql, StatementHandler statementHandler) throws SQLException {
        Connection connection = (Connection) invocation.getArgs()[0];
        String countSql = "select count(*) as count " + MybatisUtil.getMasterFrom(0,sql);
        log.info("[page - plugin] 生成记录总条数的sql语句 - {}",countSql);

        PreparedStatement ps = connection.prepareStatement(countSql);
        // 设置sql执行的参数 -- 借助mybatis本身的机制设置查询参数
        statementHandler.parameterize(ps);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()){
            int count = resultSet.getInt("count");
            log.info("[page - plugin] 获取查询的总条数 - {}",count);
            return count;
        }
        resultSet.close();
        ps.close();
        return 0;
    }
}
