package me.matchers.spark.commands.gamemode;
/*/
Created by Matchers on 4/20/2021
 */


import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;

public class SurvivalCommand extends PluginCommand {

    @Command(name = "gm.s", aliases = {"gamemode.0", "gms"}, permission = "rank.admin")
    public void onCommand(CommandArgs command) {
        Player sender = command.getPlayer();
        org.bukkit.command.Command.broadcastCommandMessage(command.getSender(), "Gamemode set to SURVIVAL.");
        sender.setGameMode(GameMode.SURVIVAL);
    }
}