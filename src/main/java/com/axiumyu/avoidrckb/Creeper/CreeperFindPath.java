package com.axiumyu.avoidrckb.Creeper;

import com.destroystokyo.paper.event.entity.EntityPathfindEvent;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static com.axiumyu.avoidrckb.AxiumyuUtil.getEntityDistance;
import static com.axiumyu.avoidrckb.AxiumyuUtil.getEntityMiddle;
import static java.lang.Math.random;

public class CreeperFindPath implements Listener {
    @EventHandler
    public void onCreeperFind(EntityPathfindEvent pe) {
        if (pe.getEntityType().equals(EntityType.CREEPER) && pe.getTargetEntity() instanceof Player) {
            if (getEntityDistance(pe.getEntity(), pe.getTargetEntity()) <= 5) {
                int chance = (int) (random() * 1000 + 1);
                if (chance <= 50) {
                    PotionEffect resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 5, false, false);
                    Creeper sss = (Creeper) pe.getEntity();
                    sss.addPotionEffect(resistance);
                    Player pl = (Player) pe.getTargetEntity();
                    Creeper cre =(Creeper) pl.getWorld().spawnEntity(getEntityMiddle(pl, sss), EntityType.CREEPER);
                    cre.setFuseTicks(1);
                }
            }
        }
    }
}
