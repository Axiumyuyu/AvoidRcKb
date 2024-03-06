package com.axiumyu.avoidrckb;

import com.axiumyu.avoidrckb.String.Strings;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static com.axiumyu.avoidrckb.AvoidRcKb.equalsIE;
import static com.axiumyu.avoidrckb.AxiumyuUtil.REALAPPLE;
import static com.axiumyu.avoidrckb.AxiumyuUtil.combineString;

public class RealApple implements Listener {
    @EventHandler
    public void onRealEat(PlayerItemConsumeEvent ce) {
        Player pl = ce.getPlayer();
        if (equalsIE(ce.getItem(), REALAPPLE)) {
            if (pl.getGameMode() != GameMode.CREATIVE) {
                ce.getItem().setAmount(ce.getItem().getAmount() - 1);
            }
            PotionEffect e1 = new PotionEffect(PotionEffectType.WATER_BREATHING, 18000, 0, false, false);
            PotionEffect e2 = new PotionEffect(PotionEffectType.CONDUIT_POWER, 6000, 1, false, false);
            PotionEffect e3 = new PotionEffect(PotionEffectType.GLOWING, 3000, 0, false, false);
            PotionEffect e4 = new PotionEffect(PotionEffectType.LUCK, 18000, 1, false, false);
            PotionEffect e5 = new PotionEffect(PotionEffectType.NIGHT_VISION, 18000, 0, false, false);
            PotionEffect e6 = new PotionEffect(PotionEffectType.FAST_DIGGING, 18000, 1, false, false);
            PotionEffect e7 = new PotionEffect(PotionEffectType.REGENERATION, 3600, 2, false, false);
            PotionEffect e8 = new PotionEffect(PotionEffectType.ABSORPTION, 18000, 4, false, false);
            PotionEffect e9 = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 3600, 1, false, false);
            PotionEffect e10 = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 18000, 0, false, false);
            PotionEffect e11 = new PotionEffect(PotionEffectType.SATURATION, 100, 9, false, false);
            PotionEffect e12 = new PotionEffect(PotionEffectType.HEALTH_BOOST, 18000, 2, false, false);
            PotionEffect[] eff = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12};
            for (PotionEffect pe : eff) {
                pl.addPotionEffect(pe);
            }
            pl.getServer().sendMessage(combineString(pl.getName(), Strings.EatApple));
        }
    }

}
