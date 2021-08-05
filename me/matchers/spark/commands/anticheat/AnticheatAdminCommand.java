package me.matchers.spark.commands.anticheat;
/*/
Created by Matchers on 4/25/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import org.bukkit.Bukkit;

public class AnticheatAdminCommand extends PluginCommand {

    @Command(name = "acadmin", permission = "rank.manager")
    public void onCommand(CommandArgs command) {
        if (command.getArgs().length == 1) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permission add " + command.getArgs(0) + " vulcan.alerts");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permission add " + command.getArgs(0) + " vulcan.profile");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permission add " + command.getArgs(0) + " vulcan.knockback");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permission add " + command.getArgs(0) + " vulcan.logs");
            command.getPlayer().sendMessage("§aMade them an anticheat admin.");
        } else {
            command.getPlayer().sendMessage("usage: /acadmin <player>");
        }
    }
}