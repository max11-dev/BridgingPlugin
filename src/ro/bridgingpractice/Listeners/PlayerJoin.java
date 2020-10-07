package ro.bridgingpractice.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ro.bridgingpractice.Util.BlockTracker;
import ro.bridgingpractice.Util.GiveItems;
import ro.bridgingpractice.Util.Tracker;
import ro.bridgingpractice.scoreboard.Scoreboard;

import java.util.UUID;

public class PlayerJoin implements Listener {

    private Tracker tracker;

    private BlockTracker blockTracker;

    private Scoreboard scoreboard;

    public PlayerJoin(Tracker tracker, Scoreboard scoreboard, BlockTracker blockTracker){

        this.tracker = tracker;
        this.scoreboard = scoreboard;
        this.blockTracker = blockTracker;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        GiveItems.giveOnJoin(event.getPlayer());

        scoreboard.createBoard(event.getPlayer());
        scoreboard.run(event.getPlayer());

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){

        tracker.getTracker(event.getPlayer()).remove(event.getPlayer());
        despawnBlocks(event.getPlayer());

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
