package bzh.strawberry.kits.command;

/*
 * This file KitsCommand is part of a project StrawKits.StrawKits.
 * It was created on 22/10/2020 22:28 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */

import bzh.strawberry.kits.StrawKits;
import bzh.strawberry.kits.gui.KitGUI;
import bzh.strawberry.kits.manager.KPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class KitsCommand implements CommandExecutor {

    private Plugin plugin;

    public KitsCommand(Plugin pl) {
        this.plugin = pl;
        this.plugin.getLogger().info("[COMMAND] Registered Command : " + getClass().getName());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command can only be executed by a player.");
            return false;
        }

        KPlayer kPlayer = StrawKits.getInstance().getKPlayer(((Player) commandSender).getUniqueId());
        if (kPlayer == null) {
            commandSender.sendMessage("§cAn error occurred while trying to execute the command.");
            return false;
        }

        new KitGUI(kPlayer.getPlayer());
        return true;
    }
}
