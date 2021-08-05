package me.matchers.spark.commands.rank.subcommand;
/*/
Created by Matchers on 5/13/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SetprefixCommand extends PluginCommand {

    @Command(name = "rank.setprefix", permission = "nuclear.command.manage")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        if (command.getArgs().length <= 2) return;
        String rank = command.getArgs(0);
        String perm = command.getArgs(1);

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms group " + rank + " meta setprefix \"" + perm + "\"");
        player.sendMessage("§aYou set the prefix of §f" + rank + " §ato §f" + perm + "§a.");
    }
}
