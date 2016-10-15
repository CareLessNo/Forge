package cn.mcraft.cn.mcraft.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class ClickInventoryEvent
implements Listener {

    @EventHandler
    public void onClickInventory(InventoryClickEvent e)
    {

        Inventory inv = e.getInventory();
        if (inv == null) return;
        if (!(e.getWhoClicked() instanceof Player)) return;
        if (inv.getName() == null) return;

        Player p = (Player)e.getWhoClicked();
        Inventory openinv = (Inventory)p.getOpenInventory();

        if (openinv == null) return;
        if (!openinv.getType().equals(InventoryType.CHEST)) return;

    }
}
