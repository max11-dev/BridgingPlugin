package ro.bridgingpractice.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;
import ro.bridgingpractice.Main;
import ro.bridgingpractice.Util.BlockTracker;

import java.util.UUID;

public class Scoreboard {

    private final Main plugin;

    private final BlockTracker blockTracker;

    public Scoreboard(Main plugin, BlockTracker blockTracker){

        this.plugin = plugin;
        this.blockTracker = blockTracker;

    }

    public void createBoard(Player player){

        ScoreboardManager manager = Bukkit.getScoreboardManager();

        UUID uuid = player.getUniqueId();

        org.bukkit.scoreboard.Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("dummy", ChatColor.RED + "Bridging Practice");

        Score score = objective.getScore(ChatColor.RED + "-=-=-=-=-=-=-=-");

        score.setScore(1);

        Score blocksPlaced = objective.getScore(ChatColor.RED + "Blocks placed: 0")/*blockTracker.blocksMap.get(uuid).size()*/;

        blocksPlaced.setScore(3);

        player.setScoreboard(scoreboard);

        System.out.println("Created!");

    }

    public void run(Player player){
        new BukkitRunnable(){

            @Override
            public void run() {

                ScoreboardManager manager = Bukkit.getScoreboardManager();
                final org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
                final Objective objective = board.registerNewObjective("test", "dummy");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.RED + "-=-=-=Bridging Practice=-=-=-");
                int amount = blockTracker.getBlocksPlaced(player.getUniqueId());
                Score score = objective.getScore(ChatColor.RED + "Blocks placed: " + amount);
                score.setScore(10);
                Score score1 = objective.getScore(ChatColor.RED + "Players online: " + Bukkit.getOnlinePlayers().size());
                score1.setScore(7);
                player.setScoreboard(board);

            }
        }.runTaskTimer(plugin, 0L, 5L);
    }

}
