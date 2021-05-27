package com.lcha.dao;

import com.lcha.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDao {
    public static ArrayList<String> getMsg() {
        ArrayList<String> as = new ArrayList();
        Connection conn = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from li";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            String str = "";

            while(resultSet.next()) {
                str = resultSet.getString(1);
                as.add(str);
            }
        } catch (SQLException var14) {
            var14.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException var13) {
                    var13.printStackTrace();
                }
            }

        }

        return as;
    }
}
