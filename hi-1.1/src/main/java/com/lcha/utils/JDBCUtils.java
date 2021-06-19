package com.lcha.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DruidDataSource dataSource;
    static{

        try {
            Properties pro = new Properties();
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(resourceAsStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        DruidPooledConnection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
//    @Test
//    public void test() throws SQLException {
//        Connection conn=null;
//        try {
//            conn = JDBCUtils.dataSource.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        String sql="select * from li";
//        PreparedStatement pre = conn.prepareStatement(sql);
//        ResultSet resultSet = pre.executeQuery();
//        Object object = resultSet.getObject(0);
//        System.out.println(object);
////        Class<Msg> a =
////        (Msg) object;
//////        QueryRunner q = new QueryRunner();
////        ResultSetHandler<Msg> rs = new BeanHandler<T>()
////        q.query(conn,sql, ResultSetHandler<Msg>);
//
//    }
}
