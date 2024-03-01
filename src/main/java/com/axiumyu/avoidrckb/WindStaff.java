package com.axiumyu.avoidrckb;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import static com.axiumyu.avoidrckb.AxiumyuUtil.WINDSTAFF;
import static java.lang.Math.*;

public class WindStaff implements Listener {

    @EventHandler
    public void onStickClick(PlayerInteractEvent sk){
        try {
            if(sk.getAction().isRightClick() && AvoidRcKb.equalsIE(sk.getItem(),WINDSTAFF)){
                Player pl=sk.getPlayer();
                float yaw = pl.getYaw();
                float pitch = pl.getPitch();
                GameMode plgm = pl.getGameMode();

                if (plgm!=GameMode.SPECTATOR) {

                    if (pl.getFoodLevel() > 0) {
                        Vector vec = pl.getVelocity();
                        double exa = 4 * abs((toRadians(abs(pitch)) - PI) / PI);
                        vec.setY(-2 * sin(toRadians(pitch)));
                        vec.setX((2 - exa) * sin(toRadians(yaw)));
                        vec.setZ(-(2 - exa) * cos(toRadians(yaw)));
                        pl.playSound(pl.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1.0F, 1.0F);
                        pl.setVelocity(vec);
                        pl.setFallDistance(-20F);
                    } else {
                        pl.sendActionBar("你没有足够的体力");
                    }

                    if (pl.getGameMode() != GameMode.CREATIVE) {
                        pl.setFoodLevel(pl.getFoodLevel() - 1);
                    }

                }
            }
        } catch (Exception ignored) {

        }
    }
}
