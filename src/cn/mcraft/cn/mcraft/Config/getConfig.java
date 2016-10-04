package cn.mcraft.cn.mcraft.Config;

import cn.mcraft.Forge;
import org.bukkit.configuration.file.FileConfiguration;

public class getConfig
{

    private static FileConfiguration Config = Forge.Config;

    public static double getDefaultValue()
    {
        double value = 0.0D;
        if (Config.get("DefaultValue") != null)
        {
            value = Config.getDouble("DefaultValue") * 1.00D;
        }
        return value;
    }

    public static int getLevelNeed(String Level)
    {
        int value = 0;
        if (Config.get("Levels." + Level ) != null)
        {
            value = Config.getInt("Levels." + Level);
        }
        return value;
    }

    public static boolean getUseMysql()
    {
        boolean value = false;
        if (Config.get("Mysql.use") != null)
        {
            value = Config.getBoolean("Mysql.use");
        }
        return value;
    }

    public static String getAddress()
    {
        String value = null;
        if (getUseMysql())
        {
            String address = Config.getString("Mysql.Address");
            String port = Config.getString("Mysql.port");
            String database = Config.getString("Mysql.DataBase");
            value = "jdbc:mysql://" + address + ":" + port +"/" + database;
        }
        return value;
    }

    public static String getUser()
    {
        String value = null;
        if (getUseMysql())
        {
            value = Config.getString("Mysql.User");
        }
        return value;
    }

    public static String getDatabase()
    {
        String value = null;
        if (getUseMysql())
        {
            value = Config.getString("Mysql.Database");
        }
        return value;
    }

    public static String getPort()
    {
        String value = null;
        if (getUseMysql())
        {
            value = Config.getString("Mysql.Port");
        }
        return value;
    }

    public static String getPassword()
    {
        String value = null;
        if (getUseMysql())
        {
            value = Config.getString("Mysql.Password");
        }
        return value;
    }

    public static String getNeedPermission()
    {
        String value = null;
        if (Config.getString("Permission") != null)
        {
            value = Config.getString("Permission");
        }
        return value;
    }
}
