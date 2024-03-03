package com.axiumyu.avoidrckb;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPoseChangeEvent;

import java.util.Collection;

import static com.axiumyu.avoidrckb.AvoidRcKb.ItemMagnetDistance;
import static com.axiumyu.avoidrckb.AxiumyuUtil.MAGNET;

public class ItemMagnet implements Listener {


    @EventHandler
    public void onShiftPress(EntityPoseChangeEvent ep) {

        try {
            if (ep.getEntityType() == EntityType.PLAYER && ep.getPose().equals(Pose.SNEAKING)) {
                Player pl = (Player) ep.getEntity();

                if (AxiumyuUtil.contains(ep,MAGNET)) {
                    Collection<Entity> entityNearBy = pl.getWorld().getEntitiesByClasses(Item.class);

                    for (Entity et : entityNearBy) {

                        if (AxiumyuUtil.getEntityDistance(pl, et) <=ItemMagnetDistance) {
                            et.teleport(pl);
                        }
                    }
                }
            }
        } catch (Exception ignored) {

        }
    }


}
