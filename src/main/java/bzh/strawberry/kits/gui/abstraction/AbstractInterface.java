package bzh.strawberry.kits.gui.abstraction;

import bzh.strawberry.kits.StrawKits;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/*
 * This file AbstractInterface is part of a project StrawKits.StrawKits.
 * It was created on 30/10/2020 at 23:22 by Uicias.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public abstract class AbstractInterface {

    protected Player player;
    protected Inventory inventory;
    protected Map<Integer, String> actions;

    public AbstractInterface(Player target, int size, String title) {
        if (size < 0 || size % 9 != 0)
            throw new IllegalArgumentException("The given size for this GUI isn't valid!");
        if (target == null)
            throw new IllegalArgumentException("The player to receive this GUI is null while he shouldn't!");

        if (title == null)
            title = "GUI nameless";

        this.actions = new HashMap<>();
        this.player = target;
        this.inventory = Bukkit.createInventory(this.player, size, title);
        StrawKits.getInstance().getKPlayer(this.player.getUniqueId()).setOpenedGUI(this);
        this.fill();
        this.player.openInventory(this.inventory);
    }

    public abstract void fill();

    public void addItem(ItemStack stack, int index, String action){
        if(index >= this.inventory.getSize())
            throw new IndexOutOfBoundsException("The specify index is above the size of the inventory.");
        if(stack == null)
            throw new IllegalArgumentException("The ItemStack is null!");
        this.inventory.setItem(index, stack);
        this.actions.put(index, action);
    }

    public abstract void onClick(ClickType clickType, ItemStack stack, String action);

    public String getAction(int index){
        return this.actions.getOrDefault(index, null);
    }
}