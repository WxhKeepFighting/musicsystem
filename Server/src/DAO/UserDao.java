package DAO;

import Entity.User;
import util.DBCon;

import java.sql.*;

public class UserDao {

    /*
     * 验证用户登录
     * 用的表是user_system
     * */
    public static String user_login(User u) {

        String bool = "false";
        String u_password = u.getS_password();
        String u_id = u.getS_id();
        String sql = "SELECT * FROM user_system where s_id="+u_id+" and s_password="+u_password+"";
        Statement statement;
        ResultSet rSet = null;
        try {
            statement = DBCon.getStatement();//在DBCon层中已经定义了statement
            rSet = statement.executeQuery(sql);
            while (rSet.next()) {
                bool = "true";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            if (rSet != null) {
                rSet.close();
            }
        } catch (NullPointerException|SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }
}
