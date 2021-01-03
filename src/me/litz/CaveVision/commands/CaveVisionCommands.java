package me.litz.CaveVision.commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CaveVisionCommands implements CommandExecutor {

    @Override

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        // Sends Development Information for CaveVision

        if (cmd.getName().equalsIgnoreCase("CaveVision")) {
            sender.sendMessage(ChatColor.AQUA + "[CaveVision] " + ChatColor.YELLOW + "v1.0 " +
                    ChatColor.GRAY + "By " + ChatColor.AQUA + "Litz " +
                    ChatColor.GRAY + "\n(Spigot: https://bit.ly/3n2wpVj)" +
                    ChatColor.GRAY + "\n(GitHub: https://bit.ly/2KUhbEI)"
            );
        }

        // On Off for Later Version

        /* else if (cmd.getName().equalsIgnoreCase("CV") && (CaveVisionOnOff == true)) {
                sender.sendMessage(ChatColor.AQUA + "[CaveVision] " + ChatColor.GREEN + "Enabled");
                CaveVisionOnOff = false;
            }
        else if (cmd.getName().equalsIgnoreCase("CV") && (CaveVisionOnOff == false)) {
            sender.sendMessage(ChatColor.AQUA + "[CaveVision] " + ChatColor.RED + "Disabled");
            CaveVisionOnOff = true;
        } */

        return true;
    }
}


