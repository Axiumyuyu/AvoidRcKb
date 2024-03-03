package com.axiumyu.avoidrckb;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.axiumyu.avoidrckb.AvoidRcKb.ItemMagnetDistance;

public class CommandDistance implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player) {
            if (s.isEmpty()) {
                Player player = (Player) sender;
                player.sendMessage("ItemMagnetDistance：" + ItemMagnetDistance);
            } else if (s.equals("reload")) {
                AvoidRcKb.getPlugin(AvoidRcKb.class).onDisable();

            }
        }

        return true;
    }
}
