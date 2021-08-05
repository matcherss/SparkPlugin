package me.matchers.spark.commands.anticheat;
/*/
Created by Matchers on 4/25/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import org.bukkit.Bukkit;

public class AnticheatModCommand extends PluginCommand {

    @Command(name = "acmod", permission = "rank.,manager")
    public void onCommand(CommandArgs command) {
        if (command.getArgs().length == 1) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permission add " + command.getArgs(0) + " vulcan.alerts");
            command.getPlayer().sendMessage("§aMade them an anticheat mod.");
        } else {
            command.getPlayer().sendMessage("usage: /acmod <player>");
        }
    }
}
