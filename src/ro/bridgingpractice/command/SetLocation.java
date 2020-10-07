package ro.bridgingpractice.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ro.bridgingpractice.Main;


public class SetLocation implements CommandExecutor {

    private Main plugin;

    public SetLocation(Main plugin){

        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("setlocation")){

            if(!(commandSender instanceof Player)) return false;

            Player player = (Player) commandSender;

            Location location = player.getLocation();

            double x = location.getX();

            double y = location.getY();

            double z = location.getZ();

            float yaw = location.getYaw();

            float pitch = location.getPitch();

            plugin.getConfig().set("teleportLocations.firstLocation.x", x);
            plugin.getConfig().set("teleportLocations.firstLocation.y", y);
            plugin.getConfig().set("teleportLocations.firstLocation.z", z);
            plugin.getConfig().set("teleportLocations.firstLocation.yaw", yaw);
            plugin.getConfig().set("teleportLocations.firstLocation.pitch", pitch);
            plugin.saveConfig();

            player.sendMessage("Location set!");

            return true;

        }
        return false;
    }
}
