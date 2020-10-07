package ro.bridgingpractice.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import ro.bridgingpractice.Main;
import ro.bridgingpractice.Util.BlockTracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BlockPlace implements Listener {

    private final Main plugin;

    BlockTracker blockTracker;

    public HashMap<UUID, List<Block>> hashMap = new HashMap<>();

    public BlockPlace(Main plugin, BlockTracker blockTracker){

        this.plugin = plugin;
        this.blockTracker = blockTracker;

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){

        if(!(event.getBlock().getType() == Material.WOOL)) return;

        Player player = event.getPlayer();

        UUID uuid = player.getUniqueId();

        if(!blockTracker.blocksMap.containsKey(uuid)){

            blockTracker.blocksMap.put(uuid, new ArrayList<>());

        }

        blockTracker.blocksMap.get(uuid).add(event.getBlock());

        blockTracker.blocksMap.put(uuid, blockTracker.blocksMap.get(uuid));

    }

}
