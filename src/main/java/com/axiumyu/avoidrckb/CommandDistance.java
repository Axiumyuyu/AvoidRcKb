package com.axiumyu.avoidrckb;

import com.axiumyu.avoidrckb.String.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.axiumyu.avoidrckb.AvoidRcKb.ItemMagnetDistance;
import static com.axiumyu.avoidrckb.AxiumyuUtil.combineString;

public class CommandDistance implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player && strings==null) {
            Player player = (Player) sender;
            player.sendMessage(combineString(Strings.DistanceGet, ItemMagnetDistance));

        } else if (strings[0].equals("set")) {
            try {
                ItemMagnetDistance= Integer.parseInt(strings[1]);
                sender.sendMessage(combineString(Strings.DistanceSet, ItemMagnetDistance));
            } catch (NumberFormatException e) {
                sender.sendMessage(Strings.Invalid_Number);
            }
        }
        return true;
    }
}
