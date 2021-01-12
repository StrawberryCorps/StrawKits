package bzh.strawberry.kits.manager;

import org.bukkit.entity.Player;

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
