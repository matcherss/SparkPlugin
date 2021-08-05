package me.matchers.spark.server;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerUtil {

    /*/
     * Send a message to all staff members
     */
    public static void sendStaffMessage(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("rank.mod")) {
                player.sendMessage(message);
            }
        }
    }

    /*/
     * Send a message to all staff members
     */
    public static void broadcast(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(message);
        }
    }
}
