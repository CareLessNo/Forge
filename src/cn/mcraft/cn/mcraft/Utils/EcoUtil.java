package cn.mcraft.cn.mcraft.Utils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;

public class EcoUtil
{
    public static Economy economy = null;

    static
    {
        try
        {
            RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
            if (economyProvider != null) {
                economy = (Economy)economyProvider.getProvider();
            }
        }
        catch (Exception localException) {}
        if (economy == null) {
            MainUtil.info("未找到经济插件");
        }
    }

    public static void giveMoney(Player player, double money)
    {
        giveMoney(player.getName(), money);
        //给予玩家money钱数
    }

    public static void giveMoney(String playerName, double money)
    {
        if ((economy != null) && (money >= 0.0D))
        {
            if (!economy.hasAccount(playerName)) {
                economy.createPlayerAccount(playerName);
            }
            economy.depositPlayer(playerName, money);
            MainUtil.info(Bukkit.getPlayerExact(playerName), "你的灵迹增加了§6$" + MainUtil.notUseScientificNotation(Double.valueOf(money)));
        }
    }

    public static boolean payMoney(Player player, double money)
    {
        return payMoney(player.getName(), money);
    }

    public static boolean payMoney(String playerName, double money)
    {
        if ((economy == null) || (money <= 0.0D)) {
            return true;
        }
        if (!economy.hasAccount(playerName)) {
            economy.createPlayerAccount(playerName);
        }
        Player player = Bukkit.getPlayerExact(playerName);
        if (economy.getBalance(playerName) < money)
        {
            MainUtil.info(player, "你的灵迹不足§6$" + MainUtil.notUseScientificNotation(Double.valueOf(money)));
            return false;
        }
        economy.withdrawPlayer(playerName, money);
        MainUtil.info(player, "你的灵迹减少了§6$" + MainUtil.notUseScientificNotation(Double.valueOf(money)));
        return true;
    }

    public static boolean hasMoney(Player player, double money)
    {
        return hasMoney(player.getName(), money);
    }

    public static boolean hasMoney(String playerName, double money)
    {
        if ((economy == null) || (money <= 0.0D)) {
            return true;
        }
        if (!economy.hasAccount(playerName)) {
            economy.createPlayerAccount(playerName);
        }
        if (economy.getBalance(playerName) < money)
        {
            MainUtil.info(Bukkit.getPlayerExact(playerName), "你的灵迹不足§6$" + MainUtil.notUseScientificNotation(Double.valueOf(money)));
            return false;
        }
        return true;
    }
}
