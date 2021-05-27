package com.lcha.dao;

import com.lcha.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class Insert {

    public static int insert(String str){
        String sql = "insert into li(msg) values(?)";
        QueryRunner qr = new QueryRunner();
        Connection conn = JDBCUtils.getConnection();
        int count=-1;
        try {
            count=qr.update(conn,sql,str);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
}
