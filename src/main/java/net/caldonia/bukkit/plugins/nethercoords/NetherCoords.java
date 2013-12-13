package net.caldonia.bukkit.plugins.nethercoords;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NetherCoords extends JavaPlugin {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return false;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("nethercoords")) {
            World world = player.getWorld();
            Location location = player.getLocation();

            player.sendMessage(world.getEnvironment().toString() + " Coordinates: " + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ());

            World.Environment otherWorld = (world.getEnvironment() == World.Environment.NORMAL ? World.Environment.NETHER : World.Environment.NORMAL);

            int x = location.getBlockX();
            int y = location.getBlockY();
            int z = location.getBlockZ();

            if (otherWorld == World.Environment.NETHER) {
                x *= 0.125;
                z *= 0.125;
            } else {
                x *= 8;
                z *= 8;
            }

            player.sendMessage(otherWorld.toString() + " Coordinates: " + x + ", " + y + ", " + z);

            return true;
        }

        return false;
    }
}