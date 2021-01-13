package bzh.strawberry.kits;

import bzh.strawberry.kits.listener.inventory.PlayerInterface;
import bzh.strawberry.kits.listener.players.PlayerJoin;
import bzh.strawberry.kits.listener.players.PlayerQuit;
import bzh.strawberry.kits.manager.KPlayer;
import bzh.strawberry.kits.manager.KitsManager;
import bzh.strawberry.kits.util.StorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/*
 * This file StrawKits is part of a project StrawKits.StrawKits.
 * It was created on 22/10/2020 22:28 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */

public class StrawKits extends JavaPlugin {

    private static StrawKits STRAW_KITS;

    public StorageUtil storageUtil;

    private KitsManager kitsManager;
    private Collection<KPlayer> kPlayers;

    @Override
    public void onEnable() {
        STRAW_KITS = this;
        long begin = System.currentTimeMillis();
        this.getLogger().info("######################## [" + this.getDescription().getName() + " - " + this.getDescription().getVersion() + "] #################################");

        this.saveDefaultConfig();

        this.getLogger().info("Starting to connect to the database...");
        this.storageUtil = StorageUtil.getInstance();
        if(this.storageUtil == null) {
            this.getLogger().severe("An internal error occurred while loading the Storage connection..");
            Bukkit.shutdown();
        }
        this.getLogger().info("Starting to connect to the database... -> DONE");

        this.getLogger().info("Starting loading kits...");
        this.kitsManager = new KitsManager();
        this.getLogger().info("Starting loading kits... -> DONE");

        this.getLogger().info("Starting loading listeners...");
        this.getServer().getPluginManager().registerEvents(new PlayerInterface(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerQuit(this), this);
        this.getLogger().info("Starting loading listeners... -> DONE");

        this.kPlayers = new ArrayList<>();
        this.getLogger().info("Plugin enabled in "+(System.currentTimeMillis() - begin)+" ms.");
        this.getLogger().info("######################## [" + this.getDescription().getName() + " - " + this.getDescription().getVersion() + "] #################################");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Closing connection to the database...");
        try {
            this.storageUtil.close();
        } catch (SQLException e) {
            this.getLogger().severe("An internal error occurred while closing the Storage connection..");
        }
        this.getLogger().info("Closing connection to the database... -> DONE");
    }

    /**
     * Get the instance to manipulate the storage
     * @return the storage instance
     */
    public StorageUtil getStorageUtil() {
        return storageUtil;
    }

    /**
     * Get the instance to manipulate the kitsManager
     * @return the kitsmanager instance
     */
    public KitsManager getKitsManager() {
        return kitsManager;
    }

    public KPlayer getKPlayer(UUID uuid) {
        return this.kPlayers.stream().filter(kPlayer -> kPlayer.getPlayer().getUniqueId().equals(uuid)).findFirst().orElse(null);
    }

    public Collection<KPlayer> getkPlayers() {
        return kPlayers;
    }

    /**
     * To return the instance of the class
     * @return the instance of the StrawKits
     */
    public static StrawKits getInstance() {
        return STRAW_KITS;
    }
}