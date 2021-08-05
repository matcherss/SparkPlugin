package me.matchers.spark.commands;
/*/
Created by Matchers on 4/25/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import me.matchers.spark.gui.punish.PunishGui;

public class PunishCommand extends PluginCommand {
    @Command(name = "punish", permission = "rank.staff", aliases = {"p"})
    public void onCommand(CommandArgs command) {
        if (command.getArgs().length != 1) {
            command.getPlayer().sendMessage("§cUsage: /punish <player>");
            return;
        }
        String player = command.getArgs(0);

        PunishGui.open(command.getPlayer(), player);

    }
}
