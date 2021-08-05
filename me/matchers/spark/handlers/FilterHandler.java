package me.matchers.spark.handlers;
/*/
Created by Matchers on 4/21/2021
 */

import org.bukkit.Bukkit;

import java.util.ArrayList;

public class FilterHandler {

    private static ArrayList<String> filtered = new ArrayList<>();

    public void load() {
        Bukkit.getConsoleSender().sendMessage("§aLoaded filtered messages");
    }

    public boolean isFiltered(String string) {
        String message = string.toLowerCase();
        for (String word : filtered) {
            return message.contains(word.toLowerCase());
        }
        return false;
    }

    public void addWord(String word) {
        filtered.add(word);
    }

    public void removeWord(String word) {
        filtered.remove(word);
    }

}
