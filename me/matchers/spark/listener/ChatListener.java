package me.matchers.spark.listener;
/*/
Created by Matchers on 4/21/2021
 */

import me.matchers.spark.SparkPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (SparkPlugin.getInstance().getFilterHandler().isFiltered(event.getMessage())) {
            //Bukkit.broadcast("§e[Filtered] §f" + player.getName() + ": " + event.getMessage(), "rank.trialmod");

            event.setCancelled(true);
        }

        //check if chat is muted
        if (SparkPlugin.getInstance().getChatHandler().isMuted()) {
            //check if they have the perm to speak
            if (!player.hasPermission("rank.staff")) {
                event.setCancelled(true); //cancel it
                player.sendMessage("§cPublic chat is muted and you do not have the permission to speak in public chat.");
            } else {
                player.sendMessage("§aPublic chat is muted, but you have the permission to bypass it.");
            }
        }

        //check if giveaway is active
        if (SparkPlugin.getInstance().getGiveawayHandler().isActive()) {
            //check if the message is the winning number
            if (event.getMessage().equals(String.valueOf(SparkPlugin.getInstance().getGiveawayHandler().getNumber()))) {
                if (!player.hasPermission("rank.staff")) {
                    SparkPlugin.getInstance().getGiveawayHandler().end(event.getPlayer()); //end giveaway.
                    event.setCancelled(true);
                } else { // prevent staff from winning because they can be retards sometimes.
                    Bukkit.broadcast("§a[Staff] §fPrevented a staff member §7(" + player.getName() + ") §ffrom winning the giveaway.", "rank.staff");
                    player.sendMessage("§aYou would've won, but you're a staff member.");
                    event.setCancelled(true);
                }
            }
        }

        if (event.getPlayer().hasPermission("rank.staff")) {

        }

        //staff
    }

}
