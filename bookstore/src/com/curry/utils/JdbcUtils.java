package com.curry.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JdbcUtils负责连接数据库和断开数据库连接
 *
 * @author RUIWU
 * @create 2020-11-21 16:34
 */
public class JdbcUtils {

    private static DataSource source;//只有一个数据源

    static {//静态代码块
        try {
            //1.加载配置文件
            Properties pros = new Properties();
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
            //2. 使用配置文件，返回DataSource的实例
            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 返回连接
     * @throws SQLException
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = source.getConnection();
        } catch (SQLException e) {
            e.getStackTrace();
        } finally {
            return conn;
        }
    }

    /**
     * 关闭资源操作
     *
     * @param conn
     */
    public static void closeResource(Connection conn) {
        if (conn == null){
            return;
        }
        DbUtils.closeQuietly(conn);
    }

}
