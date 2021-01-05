package me.litz.CaveVision;

import me.litz.CaveVision.commands.CaveVisionCommands;
import me.litz.CaveVision.events.CaveVisionEvents;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;

public class CaveVision extends JavaPlugin {


    @Override
    public void onEnable() {
        CaveVisionCommands commands = new CaveVisionCommands();
        getServer().getPluginManager().registerEvents(new CaveVisionEvents(), this);
        getCommand("CaveVision").setExecutor(commands);
        createFiles();
        // getCommand("CV").setExecutor(commands); // For Later Version
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[CaveVision]: Plugin enabled on startup");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[CaveVision]: Plugin disabled on shutdown");
    }

    private File configf;
    private FileConfiguration config;

    private void createFiles() {
        configf = new File(getDataFolder(),"config.yml");

        if (!(configf.exists())) {
            configf.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }
        config = new YamlConfiguration();

        try {
            config.load(configf);

        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}

