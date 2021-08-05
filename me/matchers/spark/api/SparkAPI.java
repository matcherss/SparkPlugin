package me.matchers.spark.api;
/*/
Created by Matchers on 4/21/2021
 */

import me.matchers.spark.SparkPlugin;
import me.matchers.spark.utils.Random;
import org.bukkit.entity.Player;

public class SparkAPI {

    private static Random random = new Random();

    public static boolean isChatMuted() {
        return SparkPlugin.getInstance().getChatHandler().isMuted();
    }

    public static void setChatMute(boolean bool) {
        SparkPlugin.getInstance().getChatHandler().setMuted(bool);
    }

    public static boolean isFrozen(Player player) {
        return SparkPlugin.getInstance().getFreezeHandler().isFrozen(player);
    }

    public static boolean isFiltered(String message) {
        return SparkPlugin.getInstance().getFilterHandler().isFiltered(message);
    }

    public static void freezePlayer(Player player) {
        SparkPlugin.getInstance().getFreezeHandler().freeze(player);
    }

    public static void unFreezePlayer(Player player) {
        SparkPlugin.getInstance().getFreezeHandler().unfreeze(player);
    }

    public static Random getRandom() {
        return random;
    }

}
