package me.matchers.spark.commands;
/*/
Created by Matchers on 4/21/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import me.matchers.spark.SparkPlugin;
import org.bukkit.command.CommandSender;

public class SparkReloadCommand extends PluginCommand {

    @Command(name = "spark.reload", permission = "spark.reload")
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        sender.sendMessage("§aReloading Spark config...");
        SparkPlugin.getInstance().reloadConfig();
        sender.sendMessage("§aReloaded.");
    }
}
