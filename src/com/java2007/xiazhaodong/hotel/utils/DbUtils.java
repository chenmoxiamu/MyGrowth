package com.java2007.xiazhaodong.hotel.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author AzureSky_X
 * @Date 2020/11/10 20:47
 * @Version 1.0
 */
public class DbUtils {
    private static DruidDataSource ds;
    private static final  ThreadLocal<Connection>THREAD_LOCAL =new ThreadLocal<>();
    static {
        Properties properties=new Properties();
        InputStream inputStream=DbUtils.class.getResourceAsStream("/database.properties");

        try {
            properties.load(inputStream);
            ds= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static Connection getConnection(){
        Connection connection=THREAD_LOCAL.get();
        try {
            if (connection==null){
                connection=ds.getConnection();
                THREAD_LOCAL.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static  void begin(){
        Connection connection=null;
        connection=getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static void commit(){
        Connection connection=null;
        connection=getConnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }
    public static void rollback(){
        Connection connection=null;
        connection=getConnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }
    public  static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
                THREAD_LOCAL.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
