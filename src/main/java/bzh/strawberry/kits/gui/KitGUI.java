package bzh.strawberry.kits.gui;

import bzh.strawberry.kits.StrawKits;
import bzh.strawberry.kits.gui.abstraction.AbstractInterface;
import bzh.strawberry.kits.manager.Kit;
import bzh.strawberry.kits.util.ItemStackBuilder;
import bzh.strawberry.kits.util.SkullItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/*
 * This file KitGUI is part of a project StrawKits.StrawKits.
 * It was created on 13/01/2021 15:16 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class KitGUI extends AbstractInterface {

    private int page = 0;

    public KitGUI(Player target) {
        super(target, 54, "Kits");
    }

    @Override
    public void fill() {
        this.clean();
        int[] bordures = {0, 1, 2, 3, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};
        for (int i : bordures)
            this.addItem(new ItemStackBuilder(Material.BLUE_STAINED_GLASS_PANE, 1, ""), i, "");

        this.addItem(new ItemStackBuilder(Material.DIAMOND, 1, "§3Kits"), 4, null);

        if (page != 0) this.addItem(new SkullItemBuilder(null, "http://textures.minecraft.net/texture/bd69e06e5dadfd84e5f3d1c21063f2553b2fa945ee1d4d7152fdc5425bc12a9", "§3Page précédente"), 45, "previous");
        if (page != pageMax()) this.addItem(new SkullItemBuilder(null, "http://textures.minecraft.net/texture/19bf3292e126a105b54eba713aa1b152d541a1d8938829c56364d178ed22bf", "§3Page suivante"), 53, "next");

        int[] posKit= {20,21,22,23,24,29,30,31,32,33};

        for (int i = 0; i <= 9; i++) {
            if (i + page * 10 == StrawKits.getInstance().getKitsManager().getKits().size()) break;
            Kit kit = StrawKits.getInstance().getKitsManager().getKits().get(page * 10 + i);
            if (kit != null)
                this.addItem(new ItemStackBuilder(Material.ENDER_CHEST, 1, kit.getName()), posKit[i], "kit_" + kit.getName());
        }
    }

    @Override
    public void onClick(ClickType clickType, ItemStack stack, String action) {
        if (action.isEmpty()) return;

        if (action.equals("next")) {
            page++;
            fill();
        }

        if (action.equals("previous")) {
            page--;
            fill();
        }

        if (action.startsWith("kit_") && clickType.isLeftClick()) {
            Kit kit = StrawKits.getInstance().getKitsManager().getKit(action.substring(4).toLowerCase());
            System.out.println(kit);
        } else if (action.startsWith("kit_") && clickType.isRightClick()) {
            Kit kit = StrawKits.getInstance().getKitsManager().getKit(action.substring(4).toLowerCase());

        }

    }


    public int pageMax() {
        return (StrawKits.getInstance().getKitsManager().getKits().size() / 10);
    }

}