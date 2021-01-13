package bzh.strawberry.kits.manager;

import bzh.strawberry.kits.gui.abstraction.AbstractInterface;
import org.bukkit.entity.Player;

/*
 * This file KPlayer is part of a project StrawKits.StrawKits.
 * It was created on 13/01/2021 10:33 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class KPlayer {

    private Player player;
    private boolean inventoryOpened;
    private AbstractInterface openedGUI;

    public KPlayer(Player player) {
        this.player = player;
        this.inventoryOpened = false;
    }

    public Player getPlayer() {
        return player;
    }

    public AbstractInterface getOpenedGUI() {
        return openedGUI;
    }

    public void setOpenedGUI(AbstractInterface openedGUI) {
        this.openedGUI = openedGUI;
    }
}