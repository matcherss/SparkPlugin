package me.matchers.spark.commands.rank;
/*/
Created by Matchers on 5/13/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import org.bukkit.entity.Player;

public class RankCommand extends PluginCommand {

    @Command(name = "rank", permission = "nuclear.command.manage")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.sendMessage("§7§m---------------------------------------------");
        player.sendMessage("§c/rank setprefix <rank> <prefix>");
        player.sendMessage("§c/rank setcolor <rank> <code>");
        player.sendMessage("§c/rank create <rank>");
        player.sendMessage("§c/rank addperm <rank> <perm>");
        player.sendMessage("§c/rank setweight <rank> <weight>");
        player.sendMessage("§c/rank inherit <rank> <toinherit>");
        player.sendMessage("§c/rank delperm <rank> <perm>");
        player.sendMessage(" ");
        player.sendMessage("§c/setrank <player> <rank>");
        player.sendMessage("§7§m---------------------------------------------");
    }
}
