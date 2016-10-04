package cn.mcraft;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Forge
extends JavaPlugin
{

    public static Forge instance = null;
    public static FileConfiguration Config = null;

    public void onEnable()
    {
        instance = this;
        Config = instance.getConfig();
        saveDefaultConfig();
    }

    public void onDisbale()
    {

    }
}
