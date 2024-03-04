package com.axiumyu.avoidrckb;

import com.axiumyu.avoidrckb.String.Strings;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import static com.axiumyu.avoidrckb.AxiumyuUtil.*;

public final class AvoidRcKb extends JavaPlugin implements Listener{
    public static int ItemMagnetDistance=10;
/*
    static ShapelessRecipe b1 =CreateShapelessRecipe(2,book0,book1);

    static ShapelessRecipe b2 =CreateShapelessRecipe(2,book1,book2);

    static ShapelessRecipe b3 =CreateShapelessRecipe(2,book2,book3);

    static ShapelessRecipe b4 =CreateShapelessRecipe(2,book3,book4);

    static ShapelessRecipe b24 =CreateShapelessRecipe(4,book0,book2);

    static ShapelessRecipe b34 = CreateShapelessRecipe(4,book1,book3);

    static ShapelessRecipe b44 = CreateShapelessRecipe(4,book2,book4);

    static ShapelessRecipe b38 =CreateShapelessRecipe(8,book0,book3);

    static ShapelessRecipe b48 = CreateShapelessRecipe(8,book1,book4);

    static ShapelessRecipe d1 = CreateShapelessRecipe(1,book1,genItem(Material.KNOWLEDGE_BOOK,2));

    static ShapelessRecipe d2 = CreateShapelessRecipe(1,book2,genItem(Material.KNOWLEDGE_BOOK,4));

    static ShapelessRecipe d3 = CreateShapelessRecipe(1,book1,genItem(Material.KNOWLEDGE_BOOK,8));

    static ShapelessRecipe d4 = CreateShapelessRecipe(1,book1,genItem(Material.KNOWLEDGE_BOOK,16));

    static ShapelessRecipe[] slp={b1,b2,b3,b4,b24,b38,b34,b44,b48,d1,d2,d3,d4};
*/


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
        NamespacedKey nas = new NamespacedKey(this, "a");
        ShapelessRecipe recipe = new ShapelessRecipe(nas, new ItemStack(Material.NETHERITE_INGOT));
        recipe.addIngredient(2,book0);
        // Plugin startup logic
        saveResource("config.yml",false);
        saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        config.addDefault("ItemMagnetDistance",10);
        config.options().copyDefaults(true);
        saveConfig();
        ItemMagnetDistance=config.getInt("ItemMagnetDistance");

        CompressBook cb =new CompressBook(nas);
        for (ShapelessRecipe sp : cb.slp){
            Bukkit.addRecipe(sp);
        }

        this.getCommand("distance").setExecutor(new CommandDistance());

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

        Bukkit.resetRecipes();
        getLogger().info("插件已卸载！");
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
        try {
            ie.setCancelled(true);

            pl.sendActionBar(combineString(Strings.DoNotRC,ie.getItem().getI18NDisplayName()));
            pl.playSound(pl.getLocation(), Sound.ENTITY_CAT_AMBIENT, SoundCategory.AMBIENT, 1.0F,1.0F);
        } catch (Exception ignored) {

        }
    }
}

