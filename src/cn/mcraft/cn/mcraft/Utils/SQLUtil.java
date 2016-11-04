package cn.mcraft.cn.mcraft.Utils;


import cn.mcraft.cn.mcraft.Config.getConfig;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUtil {
    static String URL = getConfig.getAddress();
    static String User = getConfig.getUser();
    static String Password = getConfig.getPassword();

    public static void createTable() {
        try {
            Connection conn = DriverManager.getConnection(URL, User, Password);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS `ForgeMen` (`player` VARCHAR(40) PRIMARY KEY, `exp` DOUBLE, `Drawings` VARCHAR(400);");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}