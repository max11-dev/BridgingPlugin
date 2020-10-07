package ro.bridgingpractice.Util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import ro.bridgingpractice.Main;

public class Locations {

    private Main plugin;

    public Locations(Main plugin){

        this.plugin = plugin;

    }

    public Location getLocation(){

        World world = Bukkit.getServer().getWorld(plugin.getConfig().getString("world"));

        double x = plugin.getConfig().getDouble("teleportLocations.firstLocation.x");

        double y = plugin.getConfig().getDouble("teleportLocations.firstLocation.y");

        double z = plugin.getConfig().getDouble("teleportLocations.firstLocation.z");

        float yaw = (float) plugin.getConfig().getDouble("teleportLocations.firstLocation.yaw");

        float pitch = (float) plugin.getConfig().getDouble("teleportLocations.firstLocation.pitch");

        Location loc = new Location(world, x, y, z, yaw, pitch);

        return loc;

    }

}
