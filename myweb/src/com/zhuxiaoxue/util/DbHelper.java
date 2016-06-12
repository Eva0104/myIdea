package com.zhuxiaoxue.util;
import com.zhuxiaoxue.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import java.sql.Connection;
import java.sql.SQLException;

public class DbHelper {

    public static void update(String sql, Object... params) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        try {
            queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            throw new DataAccessException("执行" + sql + "时异常");
        }
    }

    public static <T> T query(String sql,  ResultSetHandler<T> handler,Object...params ){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        try {
            return queryRunner.query(connection,sql,handler,params);
        } catch (SQLException e) {
            throw new DataAccessException("执行" + sql + "语句时异常");
        }
    }
}
