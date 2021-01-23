package bzh.strawberry.kits.gui;

import bzh.strawberry.kits.StrawKits;
import bzh.strawberry.kits.gui.abstraction.AbstractInterface;
import bzh.strawberry.kits.manager.Kit;
import bzh.strawberry.kits.util.ItemStackBuilder;
import bzh.strawberry.kits.util.SkullItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

/*
 * This file KitGUI is part of a project StrawKits.StrawKits.
 * It was created on 13/01/2021 15:16 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class KitViewerGUI extends AbstractInterface {

    private Kit kit;

    public KitViewerGUI(Player target, Kit kit) {
        super(target, 36, kit.getName());
        this.kit = kit;
    }

    @Override
    public void fill() {
        this.addItem(new ItemStack(Material.STONE), 35, "");
       for (Kit.KitItem kitItem : kit.getItems()) {
           this.addItem(kitItem.getItemStack(), kitItem.getPosition(), "");
       }
    }

    @Override
    public void onClick(ClickType clickType, ItemStack stack, String action) {

    }
}