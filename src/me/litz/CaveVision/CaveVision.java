package me.litz.CaveVision;

import me.litz.CaveVision.commands.CaveVisionCommands;
import me.litz.CaveVision.events.CaveVisionEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CaveVision extends JavaPlugin {

    // public static boolean CaveVisionOnOff = false;

    @Override
    public void onEnable() {
        CaveVisionCommands commands = new CaveVisionCommands();
        getServer().getPluginManager().registerEvents(new CaveVisionEvents(), this);
        getCommand("CaveVision").setExecutor(commands);
        // getCommand("CV").setExecutor(commands); // For Later Version
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[CaveVision]: Plugin enabled on startup");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[CaveVision]: Plugin disabled on shutdown");
    }
}

