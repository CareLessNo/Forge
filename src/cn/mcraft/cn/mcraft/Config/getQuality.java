package cn.mcraft.cn.mcraft.Config;

import cn.mcraft.Forge;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class getQuality {

    private static File file = new File(Forge.instance.getDataFolder() + File.separator + "Quality.yml");
    private static FileConfiguration Quality = YamlConfiguration.loadConfiguration(file);

    public static double getChance(String quality)
    {
        double value = 0.0D;
        if (Quality.get("Quality." + quality + ".Chance") != null)
        {
            value = Quality.getDouble("Quality." + quality + ".Chance") * 1.00D;
        }
        return value;
    }

    public static String getDisplay(String quality)
    {
        String value = "空设定";
        if (Quality.get("Quality." + quality + ".Display") != null)
        {
            value = Quality.getString("Quality." + quality + ".Display");
        }
        return value;
    }
}
