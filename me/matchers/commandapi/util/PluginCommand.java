package me.matchers.commandapi.util;

import me.matchers.commandapi.util.command.CommandArgs;
import me.matchers.spark.SparkPlugin;

public abstract class PluginCommand {

    public SparkPlugin main = SparkPlugin.getInstance();


    public PluginCommand() {
        main.getFramework().registerCommands(this);
    }

    public abstract void onCommand(CommandArgs command);

}
