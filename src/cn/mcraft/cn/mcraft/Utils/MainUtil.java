package cn.mcraft.cn.mcraft.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.NumberFormat;

public class MainUtil {

    public static String notUseScientificNotation(Number number)
    {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        //转数字
        return nf.format(number);
    }

    public void SendFormatMsg(Player p, String s)
    {
        p.sendMessage(formatMsg(s));
        //向玩家输出格式化后的文字
    }

    public static String formatMsg(String s)
    {
        s = ChatColor.translateAlternateColorCodes('&', "&a[&b职业锻造&a]&e " + s);
        //格式化输出默认文字
        return s;
    }

    public static void info(String msg)
    {
        info(Bukkit.getConsoleSender(), msg);
        //在后台输出日志
    }

    public static String colorCode(String s)
    {
        s = ChatColor.translateAlternateColorCodes('&', s);
        //调用颜色符号
        return s;
    }

    public static void info(CommandSender sender, String msg)
    {
        if (sender != null) {
            sender.sendMessage(colorCode(formatMsg(msg)));
        }
        //向sender输出msg内容
    }

    public static String cutColor(String s)
    {
        s = ChatColor.stripColor(s);
        //跳过颜色符号
        return s;
    }
}
