package com.axiumyu.avoidrckb;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static com.axiumyu.avoidrckb.AxiumyuUtil.*;

public final class AvoidRcKb extends JavaPlugin implements Listener{
    public static int ItemMagnetDistance=10;

    public static boolean equalsIE(ItemStack item1, ItemStack item2){
        boolean f1 = item1.getType().equals(item2.getType());
        boolean f2 = item1.getEnchantments().equals(item2.getEnchantments());
        return (f1 && f2);
    }

    public static boolean equals(Material m1, Material m2){
        return (m1==m2);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveResource("config.yml",false);
        saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        config.addDefault("ItemMagnetDistance",10);
        config.options().copyDefaults(true);
        saveConfig();
        ItemMagnetDistance=config.getInt("ItemMagnetDistance");

        ThrowableFireBall tb = new ThrowableFireBall();
        ItemMagnet im =new ItemMagnet();
        WindStaff ws = new WindStaff();
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(tb,this);
        getServer().getPluginManager().registerEvents(ws,this);
        getServer().getPluginManager().registerEvents(im,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void OnRightClickCancel(PlayerInteractEvent ie){
        try {
            Player pl = ie.getPlayer();
            if (AvoidRcKb.equals(ie.getMaterial(),Material.KNOWLEDGE_BOOK) && ie.getAction().isRightClick()){
                stopClick(ie, pl);

            }else if (AvoidRcKb.equalsIE(ie.getItem(), JST) && ie.getAction().isRightClick()){
                stopClick(ie, pl);

            }else if (AvoidRcKb.equalsIE(ie.getItem(), MAGNET)) {
                stopClick(ie, pl);
            }

        } catch (Exception ignored) {

        }
    }

    private static void stopClick(PlayerInteractEvent ie, Player pl) {
        ie.setCancelled(true);
        pl.sendActionBar("请勿右键点击"+ Objects.requireNonNull(ie.getItem()).getI18NDisplayName());
        pl.playSound(pl.getLocation(), Sound.ENTITY_CAT_AMBIENT, SoundCategory.AMBIENT, 1.0F,1.0F);
    }
}

