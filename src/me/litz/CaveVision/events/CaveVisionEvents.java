package me.litz.CaveVision.events;
import me.litz.CaveVision.commands.CaveVisionCommands;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CaveVisionEvents implements Listener {

    private static int CaveEntrance[] = new int[1];;
    private static boolean enteredCave = false;

    @EventHandler
    public static void onPlayerWalk(PlayerMoveEvent event){
            Player player = event.getPlayer();
            int x = player.getLocation().getBlockX();
            int y = player.getLocation().getBlockY();
            int z = player.getLocation().getBlockZ();

            Material face = player.getWorld().getBlockAt(x, y + 1, z).getType();
            Material feet = player.getWorld().getBlockAt(x, y - 1, z).getType();

            if (face == Material.CAVE_AIR && player.hasPermission("CaveVision.use")
                    && (!(player.getWorld().getEnvironment().equals(World.Environment.NETHER)))) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 10000000, 1));
                enteredCave = true;
                if (y + 1 > CaveEntrance[0]) {
                    CaveEntrance[0] = (y + 1);
                    enteredCave = false;
                }
            } else if ((y + 1) < (CaveEntrance[0]) && (face == Material.AIR && player.hasPermission("CaveVision.use")
                    && (!(player.getWorld().getEnvironment().equals(World.Environment.NETHER))))) {
                if (feet == Material.GRASS_BLOCK) {
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    CaveEntrance[0] = 1;
                    enteredCave = false;
                } else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 10000000, 1));
                    enteredCave = true;
                }
            }

            else if (y + 1 > (CaveEntrance[0]) && face == Material.AIR && player.hasPermission("CaveVision.use")
            && (!(player.getWorld().getEnvironment().equals(World.Environment.NETHER))
            && (player.getActivePotionEffects().equals(player.hasPotionEffect(PotionEffectType.NIGHT_VISION)))
            && (enteredCave == false))) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                CaveEntrance[0] = 1;
            }
    }
}
