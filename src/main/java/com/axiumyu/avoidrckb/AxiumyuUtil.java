package com.axiumyu.avoidrckb;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityPoseChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

import static java.lang.Math.sqrt;
import static net.kyori.adventure.text.Component.text;

public class AxiumyuUtil {

    /* 使用genItem方法生成特定的特殊物品在其他类使用
     * 其他位置不产生新物品*/

    public static final ItemStack MAGNET = genItem(Material.PLAYER_HEAD, Enchantment.LOOT_BONUS_BLOCKS, 3);
    public static final ItemStack JST = genItem(Material.CREEPER_HEAD, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
    public static final ItemStack WINDSTAFF = genItem(Material.STICK, Enchantment.PROTECTION_FALL, 4);
    public static final ItemStack FIREBALL = genItem(Material.FIRE_CHARGE, Enchantment.PROTECTION_FIRE, 4);
    public static final ItemStack book0 = new ItemStack(Material.KNOWLEDGE_BOOK);
    public static final ItemStack book1 = genItem(Material.KNOWLEDGE_BOOK, Enchantment.DURABILITY, 1);
    public static final ItemStack book2 = genItem(Material.KNOWLEDGE_BOOK, Enchantment.DURABILITY, 2);
    public static final ItemStack book3 = genItem(Material.KNOWLEDGE_BOOK, Enchantment.DURABILITY, 3);
    public static final ItemStack book4 = genItem(Material.KNOWLEDGE_BOOK, Enchantment.DURABILITY, 4);


/*
    // Component to text
    final String jsonText = JSONComponentSerializer.json().serialize(Component.text("Hello world", TextColor.color(0xB9FFB7)));

    // JSON string to component
    final Component comp = JSONComponentSerializer.json().deserialize(jsonText);
*/


    public static String getComponentMessage(Component com) {
        StringBuilder stb = new StringBuilder(com.toString());
        int end = stb.indexOf("\"", 27);
        return stb.subSequence(27, end).toString();

    }

    public static Component combineString(Component com, String str) {
        return text()
                .append(com)
                .append(Component.text(str).style(com.style()))
                .build();
    }

    public static Component combineString(String str, Component com) {
        return text()
                .append(Component.text(str).style(com.style()))
                .append(com)
                .build();
    }

    public static Component combineString(Component com, int num) {
        return text()
                .append(com)
                .append(Component.text(num).style(com.style()))
                .build();
    }

    public static Component combineString(int num, Component com) {
        return text()
                .append(Component.text(num).style(com.style()))
                .append(com)
                .build();
    }

    public static double getEntityDistance(Entity e1, Entity e2) {
        Location l1 = e1.getLocation();
        Location l2 = e2.getLocation();
        double dx2 = (l1.getX() - l2.getX()) * (l1.getX() - l2.getX());
        double dy2 = (l1.getY() - l2.getY()) * (l1.getY() - l2.getY());
        double dz2 = (l1.getZ() - l2.getZ()) * (l1.getZ() - l2.getZ());
        return sqrt(dx2 + dy2 + dz2);
    }

    public static boolean contains(EntityPoseChangeEvent ep, ItemStack item) {
        boolean contain = false;
        Player pl = (Player) ep.getEntity();
        for (int i = 0; i <= pl.getInventory().getSize(); i++) {
            ItemStack is = pl.getInventory().getItem(i);
            if (is != null && AvoidRcKb.equalsIE(is, item)) {
                contain = true;
                break;

            }
        }
        return contain;
    }

    public static ItemStack genItem(Material mat, Enchantment ench, int lvl) {
        ItemStack item = null;
        try {
            item = new ItemStack(mat);
            item.addUnsafeEnchantment(ench, lvl);
        } catch (Exception ignored) {

        }
        return item;
    }

    public static ItemStack genItem(Material mat, int amount) {
        ItemStack item = new ItemStack(mat);
        item.setAmount(amount);
        return item;
    }

    public static ItemStack genItem(Material mat, Enchantment ench, int lvl, Attribute att, AttributeModifier.Operation operation, Double amount) {
        ItemStack item = new ItemStack(mat);
        try {
            item.addUnsafeEnchantment(ench, lvl);
            AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "noName", amount, operation);
            ItemMeta im = null;
            im.addAttributeModifier(att, modifier);
            item.setItemMeta(im);
        } catch (Exception ignored) {

        }
        return item;
    }

    public static ItemStack genItem(Material mat, Enchantment ench, int lvl, Attribute att, AttributeModifier.Operation operation, Double amount, String name, UUID uuid) {
        ItemStack item = new ItemStack(mat);
        try {
            item.addUnsafeEnchantment(ench, lvl);
            AttributeModifier modifier = new AttributeModifier(uuid, name, amount, operation);
            ItemMeta im = null;
            im.addAttributeModifier(att, modifier);
            item.setItemMeta(im);
        } catch (Exception ignored) {

        }
        return item;
    }

}
