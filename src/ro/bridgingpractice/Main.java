package ro.bridgingpractice;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;
import ro.bridgingpractice.Listeners.BlockPlace;
import ro.bridgingpractice.Listeners.EntityDamage;
import ro.bridgingpractice.Listeners.PlayerJoin;
import ro.bridgingpractice.Listeners.PlayerMove;
import ro.bridgingpractice.Util.BlockTracker;
import ro.bridgingpractice.Util.Tracker;
import ro.bridgingpractice.Util.Util;
import ro.bridgingpractice.command.SetLocation;
import ro.bridgingpractice.scoreboard.Scoreboard;

public class Main extends JavaPlugin implements Listener {

    Tracker tracker;

    BlockTracker blockTracker;

    Scoreboard scoreboard;

    @Override
    public void onEnable(){

        tracker = new Tracker();
        blockTracker = new BlockTracker();
        scoreboard = new Scoreboard(this, blockTracker);

        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new PlayerJoin(tracker, scoreboard, blockTracker, this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerMove(this, tracker, blockTracker, scoreboard), this);
        this.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlace(this, blockTracker), this);
        this.getServer().getPluginManager().registerEvents(this, this);

        getCommand("setlocation").setExecutor(new SetLocation(this));

    }

    @Override
    public void onDisable(){



    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();

        String message = event.getMessage();

        if(message.contains("joined the game")){

            System.out.println("Da");

            event.setCancelled(true);

            Bukkit.getServer().broadcastMessage(Util.format("&7[&2+&7] &8" + event.getPlayer().getName()));

            return;

        }else if(message.contains("left the game")){

            System.out.println("Da");

            event.setCancelled(true);

            Bukkit.getServer().broadcastMessage(Util.format("&7[&4-&7] &7" + event.getPlayer().getName()));

            return;

        }

        event.setCancelled(true);

        player.sendMessage(Util.format("&l&6Chat-ul este dezactivat. Pentru raportarea problemelor, imi poti da mesaj pe Discord!"));

    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){

        Player player = event.getPlayer();

        String message = event.getMessage();

        if(message.equalsIgnoreCase("/pl") || message.equalsIgnoreCase("/plugins")){

            event.setCancelled(true);

            player.sendMessage(Util.format("&9Developer: max11"));
            player.sendMessage("");
            player.sendMessage(Util.format("&6Discord: max11#8888"));

        }

    }

}
