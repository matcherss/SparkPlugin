package me.matchers.spark.listener;
/*/
Created by Matchers on 4/25/2021
 */

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {


    @EventHandler
    public void onPreProcessCommand(PlayerCommandPreprocessEvent event) {
        String[] args = event.getMessage().split(" ");
        if (args[0].contains("/to") || args[0].contains("/targetoffset")) {
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "blacklist " + event.getPlayer().getName() + " Attempting to crash server using /to");
            event.getPlayer().sendMessage("§cYou cannot do that!");
            event.setCancelled(true);
        }
    }

}
