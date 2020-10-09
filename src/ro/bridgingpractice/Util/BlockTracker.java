package ro.bridgingpractice.Util;

import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BlockTracker {

    public HashMap<UUID, List<Block>> blocksMap = new HashMap<>();
    public List<Block> list = new ArrayList<>();

    public int getBlocksPlaced(UUID uuid){

        if (blocksMap.get(uuid).size() == 0) return 0;

        return blocksMap.get(uuid).size();
    }

}
