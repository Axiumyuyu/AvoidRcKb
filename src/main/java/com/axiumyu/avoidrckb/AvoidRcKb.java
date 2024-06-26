package com.axiumyu.avoidrckb;

import com.axiumyu.avoidrckb.Creeper.CreeperFindPath;
import com.axiumyu.avoidrckb.Creeper.CreeperSpeed;
import com.axiumyu.avoidrckb.String.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import static com.axiumyu.avoidrckb.AxiumyuUtil.*;

public final class AvoidRcKb extends JavaPlugin implements Listener {
    public static int ItemMagnetDistance = 10;


    public static boolean equalsIE(ItemStack item1, ItemStack item2) {
        boolean f1 = item1.getType().equals(item2.getType());
        boolean f2 = item1.getEnchantments().equals(item2.getEnchantments());
        return (f1 && f2);
    }

    public static boolean equals(Material m1, Material m2) {
        return (m1 == m2);
    }

    @Override
    public void onEnable() {
        Bukkit.resetRecipes();
        CompressBook cb = new CompressBook();
        saveResource("config.yml", false);
        saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        config.addDefault("ItemMagnetDistance", 10);
        config.options().copyDefaults(true);
        saveConfig();
        ItemMagnetDistance = config.getInt("ItemMagnetDistance");
        for (ShapelessRecipe sp : cb.slp) {
            Bukkit.addRecipe(sp);
        }

        this.getCommand("distance").setExecutor(new CommandDistance());

        ThrowableFireBall tb = new ThrowableFireBall();
        ItemMagnet im = new ItemMagnet();
        WindStaff ws = new WindStaff();
        RealApple ra =new RealApple();
        CreeperSpeed cs =new CreeperSpeed();
        CreeperFindPath cp =new CreeperFindPath();
        getServer().getPluginManager().registerEvents(cs, this);
        getServer().getPluginManager().registerEvents(cp, this);
        getServer().getPluginManager().registerEvents(ra, this);
        getServer().getPluginManager().registerEvents(tb, this);
        getServer().getPluginManager().registerEvents(ws, this);
        getServer().getPluginManager().registerEvents(im, this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        Bukkit.resetRecipes();
        getLogger().info("插件已卸载！");
    }

    @EventHandler
    public void OnRightClickCancel(PlayerInteractEvent ie) {
        try {
            Player pl = ie.getPlayer();
            if (AvoidRcKb.equals(ie.getMaterial(), Material.KNOWLEDGE_BOOK) && ie.getAction().isRightClick()) {
                stopClick(ie, pl);

            } else if (AvoidRcKb.equalsIE(ie.getItem(), JST) && ie.getAction().isRightClick()) {
                stopClick(ie, pl);

            } else if (AvoidRcKb.equalsIE(ie.getItem(), MAGNET)) {
                stopClick(ie, pl);
            }

        } catch (Exception ignored) {

        }
    }

    private static void stopClick(PlayerInteractEvent ie, Player pl) {
        try {
            ie.setCancelled(true);

            pl.sendActionBar(combineString(Strings.DoNotRC, ie.getItem().getI18NDisplayName()));
            pl.playSound(pl.getLocation(), Sound.ENTITY_CAT_AMBIENT, SoundCategory.AMBIENT, 1.0F, 1.0F);
        } catch (Exception ignored) {

        }
    }
}

