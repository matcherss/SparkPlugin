package me.matchers.spark.commands.chat;
/*/
Created by Matchers on 4/21/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import me.matchers.spark.SparkPlugin;
import me.matchers.spark.handlers.ChatHandler;
import org.bukkit.Bukkit;

public class MutechatCommand extends PluginCommand {

    ChatHandler handler = SparkPlugin.getInstance().getChatHandler();

    @Command(name = "mutechat", permission = "rank.trialmod")
    public void onCommand(CommandArgs command) {
        if (!handler.isMuted()) {
            handler.setMuted(true);
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§cPublic chat is now muted!");
            Bukkit.broadcastMessage("§7You can no longer talk in chat.");
            Bukkit.broadcastMessage("");
        } else {
            handler.setMuted(false);
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§aPublic chat is no longer muted!");
            Bukkit.broadcastMessage("§7You can now talk in chat.");
            Bukkit.broadcastMessage("");
        }
    }
}
