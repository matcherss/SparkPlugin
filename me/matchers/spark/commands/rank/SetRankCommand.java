package me.matchers.spark.commands.rank;
/*/
Created by Matchers on 5/13/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SetRankCommand extends PluginCommand {

    @Command(name = "updaterank", permission = "nuclear.command.manage")
    public void onCommand(CommandArgs command) {
        Player sender = command.getPlayer();
        if (command.getArgs().length != 3) {
            sender.sendMessage("§cUsage: /updaterank <name> <rank>");
        }

        String player = command.getArgs(0);
        Player updatee = Bukkit.getPlayer(command.getArgs(0));

        String rank = command.getArgs(1);
        switch (rank) {
            case "MEMBER": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + player + " group set default");
                if (updatee != null) {
                    updatee.sendMessage("§eYour rank has been set to §fdefault§e.");
                }
                break;
            }
            case "VIP": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + player + " group set vip");
                if (updatee != null) {
                    updatee.sendMessage("§eYour rank was updated! You are now a §a§lVIP§e.");
                }
                break;
            }
            case "MVP": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + player + " group set mvp");
                if (updatee != null) {
                    updatee.sendMessage("§eYour rank was updated! You are now a §d§lMVP§e.");
                }
                break;
            }
            case "YT": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + player + " group set yt");
                if (updatee != null) {
                    updatee.sendMessage("§eYour rank was updated! You are now a §c§lYoutube§e rank.");
                }
                break;
            }
            case "HELPER": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + player + " group set helper");
                if (updatee != null) {
                    updatee.sendMessage("§eYour rank was updated! You are now a §9§lHelper§e.");
                }
                break;
            }
            case "MOD": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + player + " group set mod");
                if (updatee != null) {
                    updatee.sendMessage("§eYour rank was updated! You are now a §6§lModerator§e.");
                }
                break;
            }
            case "ADMIN": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + player + " group set admin");
                if (updatee != null) {
                    updatee.sendMessage("§eYour rank was updated! You are now an §4§lAdmin§e.");
                }
                break;
            }
            case "OWNER": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + player + " group set owner");
                if (updatee != null) {
                    updatee.sendMessage("§eYour rank was updated! You are now an §4§lOwner§e.");
                }
                break;
            }
            case "DEV": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + player + " group set dev");
                if (updatee != null) {
                    updatee.sendMessage("§eYour rank was updated! You are now a §4§lDev§e.");
                }
                break;
            }
        }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "luckperms user " + rank + " parent set " + rank + "");

    }

}
