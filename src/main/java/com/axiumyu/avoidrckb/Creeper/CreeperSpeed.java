package com.axiumyu.avoidrckb.Creeper;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static java.lang.Math.random;

public class CreeperSpeed implements Listener {
    @EventHandler
    public void onCreeperSpawn(CreatureSpawnEvent se) {
        int chance = (int) (random() * 1000 + 1);
        if (se.getEntityType().equals(EntityType.CREEPER) && se.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)) {
            Creeper ssw = (Creeper) se.getEntity();
            PotionEffect speed2 = new PotionEffect(PotionEffectType.SPEED, 99999999, 1, false, true);
            PotionEffect speed1 = new PotionEffect(PotionEffectType.SPEED, 99999999, 0, false, true);

            if (chance <= 5) {
                ssw.setExplosionRadius(2);
                ssw.setPowered(false);
                ssw.setSilent(true);
                ssw.setInvisible(true);
            } else if (chance <= 50) {
                ssw.addPotionEffect(speed2);
            } else if (chance <= 200) {
                ssw.addPotionEffect(speed1);
            }
        } //else if (se.getEntityType().equals(EntityType.SKELETON) && se.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)) {
//            Skeleton sk =(Skeleton) se.getEntity();
//            if (chance<5){
//                EntityEquipment equipment = sk.getEquipment();
//                equipment.setHelmet(genItem(Material.NETHERITE_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL,5));
//                equipment.setChestplate(genItem(Material.NETHERITE_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,5));
//                equipment.setLeggings(genItem(Material.NETHERITE_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,5));
//                equipment.setBoots(genItem(Material.NETHERITE_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,5));
//                getServer().sendMessage(Component.text("A SKELETON HAS BECOME KING...").color(TextColor.color(0x1D1C30)));
//            }
//        }
    }
}
