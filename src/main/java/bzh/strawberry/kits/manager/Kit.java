package bzh.strawberry.kits.manager;
import org.bukkit.inventory.ItemStack;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
 * This file Kit is part of a project StrawKits.StrawKits.
 * It was created on 23/10/2020 16:09 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class Kit {

    private int kit_id;
    private String name;
    private JSONObject utilisation;
    private List<KitItem> items;

    /**
     * The structure for build a kit
     * @param kit_id the kit id in database
     * @param name the name of the kit
     * @param utilisation the maxuse or cooldown
     */
    public Kit(int kit_id, String name, JSONObject utilisation) {
        this.kit_id = kit_id;
        this.name = name;
        this.utilisation = utilisation;
        this.items = new ArrayList<>();
    }

    /**
     * To add some item on kit
     * @param kitItem the item to add
     * @return true if the item has been added successfully
     */
    public boolean addItem(KitItem kitItem) {
        return this.items.add(kitItem);
    }

    public int getID() {
        return kit_id;
    }

    public String getName() {
        return name;
    }

    public JSONObject getUtilisation() {
        return utilisation;
    }

    public List<KitItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Kit{" +
                "kit_id=" + kit_id +
                ", name='" + name + '\'' +
                ", utilisation=" + utilisation +
                ", items=" + items +
                '}';
    }

    public static class KitItem {
        private ItemStack itemStack;
        private int position;

        public KitItem(ItemStack itemStack, int position) {
            this.itemStack = itemStack;
            this.position = position;
        }

        public ItemStack getItemStack() {
            return itemStack;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return "KitItem{" +
                    "itemStack=" + itemStack +
                    ", position=" + position +
                    '}';
        }
    }
}