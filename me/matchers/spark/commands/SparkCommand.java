package me.matchers.spark.commands;
/*/
Created by Matchers on 4/21/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import me.matchers.spark.SparkPlugin;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;

public class SparkCommand extends PluginCommand {

    @Command(name = "spark")
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        sender.sendMessage("§7§m" + StringUtils.repeat("-" , 35));
        sender.sendMessage("§fRunning §e§lSpark §fversion §e" + SparkPlugin.getInstance().getDescription().getVersion());
        sender.sendMessage("§7§m" + StringUtils.repeat("-" , 35));
    }
}
