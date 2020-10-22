package bzh.strawberry.kits;

import org.bukkit.plugin.java.JavaPlugin;

public class StrawKits extends JavaPlugin {

    private static StrawKits STRAW_KITS;

    @Override
    public void onEnable() {
        STRAW_KITS = this;
    }

    @Override
    public void onDisable() {

    }

    /**
     * To return the instance of the class
     * @return the instance of the StrawKits
     */
    public static StrawKits getInstance() {
        return STRAW_KITS;
    }
}
