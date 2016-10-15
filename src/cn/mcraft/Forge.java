package cn.mcraft;

import cn.mcraft.cn.mcraft.Listeners.ClickInventoryEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Forge
extends JavaPlugin
{

    public static Forge instance = null;
    public static FileConfiguration Config = null;
    public static Economy vault = null;

    public void onEnable()
    {
        instance = this;
        Config = instance.getConfig();
        saveDefaultConfig();
        setupEconomy();
        EnableListener();
        saveResource("Quality.yml", false);
    }

    private boolean EnableListener()
    {
        boolean EnableStatus = false;
        try
        {
            getServer().getPluginManager().registerEvents(new ClickInventoryEvent(), this);
            EnableStatus = true;
        }
        catch (Exception localException) {}
        return EnableStatus;
    }

    private boolean DisableListener()
    {
        boolean DisableStatus = false;
        try
        {
            HandlerList.unregisterAll(this);
            DisableStatus = true;
        }
        catch (Exception localException) {}
        return DisableStatus;
    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
            vault = (Economy)economyProvider.getProvider();
        }
        return vault != null;
    }

    public void onDisbale()
    {
        DisableListener();
    }
}
