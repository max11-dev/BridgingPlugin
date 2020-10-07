package ro.bridgingpractice.Util;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Tracker {

    private HashMap<Player, Integer> tracker = new HashMap<>();

    public HashMap<Player, Integer> getTracker(Player player) {
        return tracker;
    }
}
