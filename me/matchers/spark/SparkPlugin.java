package me.matchers.spark;
/*/
Created by Matchers on 4/20/2021
 */

import me.matchers.spark.commands.PunishCommand;
import me.matchers.spark.commands.SparkCommand;
import me.matchers.spark.commands.SparkReloadCommand;
import me.matchers.spark.commands.anticheat.AnticheatAdminCommand;
import me.matchers.spark.commands.anticheat.AnticheatModCommand;
import me.matchers.spark.commands.chat.ClearchatCommand;
import me.matchers.spark.commands.chat.MutechatCommand;
import me.matchers.spark.commands.gamemode.CreativeCommand;
import me.matchers.spark.commands.gamemode.SurvivalCommand;
import me.matchers.spark.commands.giveaway.GiveawayCommand;
import me.matchers.spark.commands.rank.RankCommand;
import me.matchers.spark.commands.rank.SetRankCommand;
import me.matchers.spark.commands.rank.subcommand.*;
import me.matchers.spark.gui.punish.PunishGui;
import me.matchers.spark.handlers.ChatHandler;
import me.matchers.spark.handlers.FilterHandler;
import me.matchers.spark.handlers.FreezeHandler;
import me.matchers.spark.handlers.GiveawayHandler;
import me.matchers.spark.listener.ChatListener;
import me.matchers.spark.listener.CommandListener;
import me.matchers.spark.listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import me.matchers.commandapi.util.command.CommandFramework;

public class SparkPlugin extends JavaPlugin {

    private static SparkPlugin instance;

    private CommandFramework framework;
    private FilterHandler filterHandler;
    private FreezeHandler freezeHandler;
    private GiveawayHandler giveawayHandler;
    private ChatHandler chatHandler;

    @Override
    public void onEnable() {
        instance = this;

        framework = new CommandFramework(this);
        filterHandler = new FilterHandler();
        freezeHandler = new FreezeHandler();
        chatHandler = new ChatHandler();
        giveawayHandler = new GiveawayHandler();

        if (!this.getDescription().getName().equals("Nuclear")) {
            Bukkit.broadcastMessage("§e§lSpark §7- §fFailed to load.");
            Bukkit.shutdown();
        }

        filterHandler.load();

        registerCommands();
        registerListeners();

        Bukkit.getConsoleSender().sendMessage("§e§lSpark §7- §fPlugin loaded!");
        Bukkit.getConsoleSender().sendMessage("§e§lSpark §7- §fVersion:  " + getDescription().getVersion());
    }

    private void registerCommands() {
        new SurvivalCommand();
        new CreativeCommand();
        new PunishCommand();
        new AnticheatAdminCommand();
        new AnticheatModCommand();
        new SparkReloadCommand();
        new GiveawayCommand();
        new SparkCommand();
        new ClearchatCommand();
        new MutechatCommand();

        new RankCommand();
        new AddpermCommand();
        new DelpermCommand();
        new SetprefixCommand();
        new SetcolorCommand();
        new CreateCommand();
        new SetweightCommand();
        new InheritCommand();
        new SetRankCommand();
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new PunishGui(), this);
        Bukkit.getPluginManager().registerEvents(new CommandListener(), this);
    }

    public static SparkPlugin getInstance() {
        return instance;
    }

    public FreezeHandler getFreezeHandler() {
        return freezeHandler;
    }

    public GiveawayHandler getGiveawayHandler() {
        return giveawayHandler;
    }

    public ChatHandler getChatHandler() {
        return chatHandler;
    }

    public CommandFramework getFramework() {
        return framework;
    }

    public FilterHandler getFilterHandler() {
        return filterHandler;
    }
}
