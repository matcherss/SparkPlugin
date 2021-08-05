package me.matchers.spark.commands.giveaway;
/*/
Created by Matchers on 4/21/2021
 */

import me.matchers.commandapi.util.PluginCommand;
import me.matchers.commandapi.util.command.Command;
import me.matchers.commandapi.util.command.CommandArgs;
import me.matchers.spark.SparkPlugin;
import me.matchers.spark.utils.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GiveawayCommand extends PluginCommand {

    @Command(name = "giveaway.start", permission = "spark.giveaway")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        //start giveaway
        SparkPlugin.getInstance().getGiveawayHandler().setNumber(Random.getRandomInRange(0, 1000));
        SparkPlugin.getInstance().getGiveawayHandler().setActive(true);

        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§fA giveaway has been §astarted§f.");
        Bukkit.broadcastMessage("§fPick a number between 0 to 1000");
        Bukkit.broadcastMessage(" ");

        player.sendMessage("§aYou have successfully started a giveaway.");
        player.sendMessage("§7Winning number is " + SparkPlugin.getInstance().getGiveawayHandler().getNumber() + "");
    }
}
