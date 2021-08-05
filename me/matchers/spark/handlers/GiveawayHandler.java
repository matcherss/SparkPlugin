package me.matchers.spark.handlers;
/*/
Created by Matchers on 4/21/2021
 */

import me.matchers.spark.SparkPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GiveawayHandler {

    int number = 0;
    boolean active = false;

    public int getNumber() {
        return 0;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isActive() {
        return active;
    }

    public void end(Player player) {
        player.sendMessage(" ");
        player.sendMessage("§aCongratulations! You've won the giveaway.");
        player.sendMessage("§7The winning number was " + this.number);
        player.sendMessage(" ");

        SparkPlugin.getInstance().getChatHandler().setMuted(true);

        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§a§lThe giveaway has ended!");
        Bukkit.broadcastMessage("§aWinner: §f" + player.getName());
        Bukkit.broadcastMessage(" ");

        active = false;
        number = 0;
    }
}
