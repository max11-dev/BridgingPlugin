package ro.bridgingpractice.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import ro.bridgingpractice.Main;
import ro.bridgingpractice.Util.BlockTracker;
import ro.bridgingpractice.Util.GiveItems;
import ro.bridgingpractice.Util.Locations;
import ro.bridgingpractice.Util.Tracker;
import ro.bridgingpractice.scoreboard.Scoreboard;

import java.util.UUID;

public class PlayerMove implements Listener {

    private Main plugin;

    Tracker tracker;

    BlockTracker blockTracker;

    Scoreboard scoreboard;

    private int attempts;

    public PlayerMove(Main plugin, Tracker tracker, BlockTracker blockTracker, Scoreboard scoreboard){

        this.plugin = plugin;
        this.tracker = tracker;
        this.blockTracker = blockTracker;
        this.scoreboard = scoreboard;

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){

        if(event.getTo().getY() < plugin.getConfig().getInt("settings.teleportY")){

            Locations locations = new Locations(plugin);

            Player player = event.getPlayer();

            scoreboard.createBoard(player);

            player.teleport(locations.getLocation());

            despawnBlocks(player);

            GiveItems.giveOnJoin(event.getPlayer());

        }

    }

    public void despawnBlocks(Player player){

        UUID uuid = player.getUniqueId();

        try {

            for (Block b : blockTracker.blocksMap.get(uuid)) {

                b.setType(Material.AIR);

            }
        }catch (Exception exception){

            System.out.println("Error");

        }

        blockTracker.blocksMap.remove(uuid);

    }

}
