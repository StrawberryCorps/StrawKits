package bzh.strawberry.kits.listener.inventory;

import bzh.strawberry.kits.StrawKits;
import bzh.strawberry.kits.gui.abstraction.AbstractInterface;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.Plugin;

/*
 * This file PlayerInterface is part of a project StrawKits.StrawKits.
 * It was created on 31/10/2020 at 00:13 by Uicias.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class PlayerInterface  implements Listener {

    private Plugin plugin;

    public PlayerInterface(Plugin pl){
        this.plugin = pl;
        this.plugin.getLogger().info("[LISTENER] Registered Listener : " + getClass().getName());
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){
        if(e.getPlayer() instanceof Player && StrawKits.getInstance().getKPlayer(e.getPlayer().getUniqueId()).getOpenedGUI() != null)
            StrawKits.getInstance().getKPlayer(e.getPlayer().getUniqueId()).setOpenedGUI(null);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if (!(e.getWhoClicked() instanceof Player) && StrawKits.getInstance().getKPlayer(e.getWhoClicked().getUniqueId()) == null)
            return;

        AbstractInterface gui =  StrawKits.getInstance().getKPlayer(e. getWhoClicked().getUniqueId()).getOpenedGUI();
        if (gui == null)
            return;

        String action = gui.getAction(e.getSlot());
        if (action != null)
            gui.onClick(e.getClick(),e.getCurrentItem(), action);
        e.setCancelled(true);
    }
}