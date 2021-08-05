package me.matchers.spark.handlers;
/*/
Created by Matchers on 4/21/2021
 */

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FreezeHandler {

    private ArrayList<Player> frozenPlayers = new ArrayList<>();

    public ArrayList<Player> getFrozenPlayers() {
        return frozenPlayers;
    }

    public void freeze(Player player) {
        frozenPlayers.add(player);
    }

    public void unfreeze(Player player) {
        frozenPlayers.remove(player);
    }

    public boolean isFrozen(Player player) {
        return frozenPlayers.contains(player);
    }
}
