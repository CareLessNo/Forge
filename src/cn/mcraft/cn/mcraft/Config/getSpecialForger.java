package cn.mcraft.cn.mcraft.Config;

import cn.mcraft.Forge;
import org.bukkit.configuration.file.FileConfiguration;

public class getSpecialForger
{
    private static FileConfiguration Config = Forge.Config;

    public static double getVipForgerMulti()
    {
        double value = 0.0D;
        if (Config.get("VIP.Multiples") != null)
        {
            value = Config.getDouble("VIP.Multiples") * 1.00D;
        }
        return  value;
    }

    public static String getVipPerm()
    {
        String value = null;
        if (Config.get("VIP.NeedPerm") != null)
        {
            value = Config.getString("VIP.NeedPerm");
        }
        return value;
    }

    public static int getSeniorForgerLevel()
    {
        int value = 0;
        if (Config.get("SeniorForger.NeedLevel") != null)
        {
            value = Config.getInt("SeniorForger.NeedLevel");
        }
        return value;
    }

    public static double getSeniorForgerMulti()
    {
        double value = 0.0D;
        if (Config.get("SeniorForger.Multiples") != null)
        {
            value = Config.getDouble("Senior.Multiples") * 1.00D;
        }
        return  value;
    }
}
