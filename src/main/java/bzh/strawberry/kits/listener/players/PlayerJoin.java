package bzh.strawberry.kits.listener.players;

/*
 * This file PlayerJoin is part of a project StrawKits.StrawKits.
 * It was created on 13/01/2021 12:12 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */

import bzh.strawberry.kits.StrawKits;
import bzh.strawberry.kits.manager.KPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoin implements Listener {

    private Plugin plugin;

    public PlayerJoin(Plugin pl){
        this.plugin = pl;
        this.plugin.getLogger().info("[LISTENER] Registered Listener : " + getClass().getName());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        StrawKits.getInstance().getkPlayers().add(new KPlayer(e.getPlayer()));
    }
}