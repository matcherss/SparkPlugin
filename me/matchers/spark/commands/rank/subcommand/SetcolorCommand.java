package me.matchers.spark.commands.rank.subcommand;
/*/
Created by Matchers on 5/13/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SetcolorCommand extends PluginCommand {

    @Command(name = "rank.setcolor", permission = "nuclear.command.manage")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        if (command.getArgs().length == 3) return;
        String rank = command.getArgs(0);
        String perm = command.getArgs(1);

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms group " + rank + " meta setsuffix \"" + perm + "\"");
        player.sendMessage("§aYou set the color of §f" + rank + " §ato §f" + perm + "§a.");
    }
}
