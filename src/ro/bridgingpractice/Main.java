package ro.bridgingpractice;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ro.bridgingpractice.Listeners.BlockPlace;
import ro.bridgingpractice.Listeners.EntityDamage;
import ro.bridgingpractice.Listeners.PlayerJoin;
import ro.bridgingpractice.Listeners.PlayerMove;
import ro.bridgingpractice.Util.BlockTracker;
import ro.bridgingpractice.Util.Tracker;
import ro.bridgingpractice.command.SetLocation;
import ro.bridgingpractice.scoreboard.Scoreboard;

public class Main extends JavaPlugin {

    Tracker tracker;

    BlockTracker blockTracker;

    Scoreboard scoreboard;

    @Override
    public void onEnable(){

        tracker = new Tracker();
        blockTracker = new BlockTracker();
        scoreboard = new Scoreboard(this, blockTracker);

        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new PlayerJoin(tracker, scoreboard, blockTracker), this);
        this.getServer().getPluginManager().registerEvents(new PlayerMove(this, tracker, blockTracker, scoreboard), this);
        this.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlace(this, blockTracker), this);

        getCommand("setlocation").setExecutor(new SetLocation(this));
//        getCommand("bp").setExecutor(new Commands(this));

        // de facut o lista pentru block-urile puse de player, iar cand moare dam empty la lista.

    }

    @Override
    public void onDisable(){



    }

}
