package bzh.strawberry.kits.util;/*
 * This file SkullItemBuilder is part of a project StrawKits.StrawKits.
 * It was created on 13/01/2021 18:34 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

public class SkullItemBuilder extends ItemStackBuilder {

    public SkullItemBuilder(String name, String displayname) {
        super(Material.PLAYER_HEAD, 1, displayname);
        if (name == null) throw new AssertionError();

        SkullMeta tempSkullMeta = (SkullMeta) this.getItemMeta();
        assert tempSkullMeta != null;

        tempSkullMeta.setOwner(name);
        this.setItemMeta(tempSkullMeta);
    }

    public SkullItemBuilder(String name, String displayname, List<String> lore) {
        super(Material.PLAYER_HEAD, 1, displayname, lore);
        if (name == null) throw new AssertionError();

        SkullMeta tempSkullMeta = (SkullMeta) this.getItemMeta();
        assert tempSkullMeta != null;

        tempSkullMeta.setOwner(name);
        this.setItemMeta(tempSkullMeta);
    }

    public SkullItemBuilder(List<String> lore, String url, String displayname) {
        super(Material.PLAYER_HEAD, 1, displayname, lore);
        if (url == null) throw new AssertionError("URL can't be null !");

        SkullMeta tempSkullMeta = (SkullMeta) this.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField;
        try {
            assert tempSkullMeta != null;
            profileField = tempSkullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(tempSkullMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        this.setItemMeta(tempSkullMeta);
    }

}