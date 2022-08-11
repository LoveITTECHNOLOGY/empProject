package com.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {
    //连接池
    private  static DruidDataSource ds=new DruidDataSource();
    //线程事务
    private  static  final  ThreadLocal<Connection> THREAD_LOCAL=new ThreadLocal<>();
    //定义一个初始静态方法
    static
    {
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream("D:\\itellij java\\java project\\empProject\\src\\main\\java\\database.properties"));
            ds=(DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //定义一个连接方法
    public static Connection getConnection(){
        //从本地是事务拿一个连接
        Connection connection=THREAD_LOCAL.get();
        //如果连接为空
        try {
            if(connection==null){
                connection=ds.getConnection();
                THREAD_LOCAL.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //开启事务
    public static  void begin(){
        //定义一个空连接
        Connection connection=null;
        //如果连接不为空
        try {
            if(connection!=null){
                connection=getConnection();
                connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交事务
    public static void commit(){
        //定义一个空连接
        Connection connection=null;
        //如果连接不为空
        try {
            if(connection!=null){
                connection=getConnection();
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }
    //回滚事务
    public static void rollback(){
        //定义一个空连接
        Connection connection=null;
        //如果连接不为空
        try {
            if(connection!=null){
                connection=getConnection();
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null);
        }
    }
    //定义一个关闭所有连接的方法
    public static  void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            //如果resultset不为空
            if(resultSet!=null){
                resultSet.close();
            }
            //如果statement不为空
            if(statement!=null){
                statement.close();
            }
            //如果连接不为空
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            THREAD_LOCAL.remove();
            e.printStackTrace();
        }
    }
}
