package me.matchers.spark.commands.chat;
/*/
Created by Matchers on 4/21/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import me.matchers.spark.utils.Random;
import org.bukkit.Bukkit;

public class ClearchatCommand extends PluginCommand {

    @Command(name = "clearchat", permission = "rank.trialmod", description = "Clears the public chat")
    public void onCommand(CommandArgs command) {
        for (int i = 0; i < 100; i++) {
            Bukkit.broadcastMessage("                          [" + Random.getRandomInRange(0, 32000) + "]");
        }
        for (int i = 0; i < 100; i++) {
            Bukkit.broadcastMessage(" ");
        }
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§c§lPublic chat has been cleared!");
        Bukkit.broadcastMessage("§7Please remember to follow the chat rules.");
        Bukkit.broadcastMessage(" ");
    }
}
