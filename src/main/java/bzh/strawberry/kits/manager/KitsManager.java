package bzh.strawberry.kits.manager;

import bzh.strawberry.kits.util.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
 * This file KitsManager is part of a project StrawKits.StrawKits.
 * It was created on 22/10/2020 23:01 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */
public class KitsManager {

    private List<Kit> kits;

    public KitsManager() {
        this.kits = new ArrayList<>();

        this.load();
    }

    /**
     * This method load all kit from the database
     */
    private void load() {
        Kit kit = new Kit(1, "a1", new JSONObject());
        kit.addItem(new Kit.KitItem(new ItemStackBuilder(Material.DIAMOND_SWORD), 1));
        kits.add(kit);
        kits.add(new Kit(2, "a2", new JSONObject()));
        kits.add(new Kit(3, "a3", new JSONObject()));
        kits.add(new Kit(4, "a4", new JSONObject()));
        kits.add(new Kit(5, "a5", new JSONObject()));
        kits.add(new Kit(6, "a6", new JSONObject()));
        kits.add(new Kit(7, "a7", new JSONObject()));
        kits.add(new Kit(8, "a8", new JSONObject()));
        kits.add(new Kit(9, "a9", new JSONObject()));
        kits.add(new Kit(10, "a10", new JSONObject()));
        kits.add(new Kit(11, "a11", new JSONObject()));
        kits.add(new Kit(12, "a12", new JSONObject()));
        kits.add(new Kit(13, "a13", new JSONObject()));
        kits.add(new Kit(14, "a14", new JSONObject()));
    }

    /**
     * All the kit load by the plugin
     * @return the list of the kit loaded
     */
    public List<Kit> getKits() {
        return kits;
    }

    /**
     * To get a kit by name
     * @param name the search name
     * @return the kit object if exist
     */
    public Kit getKit(String name) {
        return this.kits.stream().filter(kit -> kit.getName().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
    }


    /**
     * Give the selected kit to player
     * @param player the player who receive the kit
     * @param kit the kit to give
     */
    public void giveKit(Player player, Kit kit) {
        /* @TODO
            - Vérification que le kit existe bien
            - Vérifier si l'utilisateur a bien le droit de recevoir le kit
            - Donner le kit et ajouter une ligne en base de données
         */
    }
}
