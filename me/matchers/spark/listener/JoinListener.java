package me.matchers.spark.listener;
/*/
Created by Matchers on 4/20/2021
 */

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);

        //player isn't staff, so return.
        if (!player.hasPermission("rank.staff")) {
            return;
        }

        Bukkit.broadcast("§a[Staff] §f" + player.getName() + " has joined.", "rank.staff");
        //todo: vanish the player
        player.sendMessage(" ");
        player.sendMessage("§6§lIncognito Mode Activated!");
        player.sendMessage("§7You can now only be seen by players §e§lTrainee§7+.");
        player.sendMessage(" ");


    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);

        //player isn't staff, so return.
        if (!player.hasPermission("rank.staff")) {
            return;
        }

        Bukkit.broadcast("§a[Staff] §f" + player.getName() + " has left.", "rank.staff");
    }

}
