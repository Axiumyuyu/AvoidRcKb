package com.axiumyu.avoidrckb;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.axiumyu.avoidrckb.AxiumyuUtil.FIREBALL;

public class ThrowableFireBall implements Listener {

    @EventHandler
    public static void onFireBallThrow(PlayerInteractEvent fb) {
        try {
            if (AvoidRcKb.equalsIE(fb.getItem(), FIREBALL) && fb.getAction().isRightClick()) {
                Player pl = fb.getPlayer();

                if (fb.getItem().getEnchantments().containsKey(Enchantment.PROTECTION_FIRE)) {
                    float pitch = pl.getPitch();
                    float yaw = pl.getYaw();
                    Location playerloc = new Location(pl.getWorld(), pl.getLocation().getX(), pl.getLocation().getY() + 1.5D, pl.getLocation().getZ(), yaw, pitch);
                    Fireball ball = (Fireball) pl.getWorld().spawnEntity(playerloc, EntityType.FIREBALL);
                    fb.getPlayer().playSound(pl.getLocation(), Sound.ENTITY_GHAST_SHOOT, 1.0F, 1.0F);

                    if (pl.getGameMode() != GameMode.CREATIVE) {
                        fb.getItem().setAmount(fb.getItem().getAmount() - 1);
                    }
                }
            }
        } catch (Exception ignored) {

        }
    }
}
