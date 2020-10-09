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

        org.bukkit.scoreboard.Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("dummy", ChatColor.RED + "Bridging Practice");

        Score score = objective.getScore(ChatColor.RED + "-=-=-=-=-=-=-=-");

        score.setScore(1);

        Score blocksPlaced = objective.getScore(ChatColor.RED + "Blocks placed: 0")/*blockTracker.blocksMap.get(uuid).size()*/;

        blocksPlaced.setScore(3);

        player.setScoreboard(scoreboard);

    }

    public void run(Player player){

        new BukkitRunnable(){

            @Override
            public void run() {

                ScoreboardManager manager = Bukkit.getScoreboardManager();

                final org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();

                final Objective objective = board.registerNewObjective("test", "dummy");

                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.GREEN + "-=Bridging Practice=-");

                Score scoreBlank = objective.getScore(" ");

                try{

                    int amount = blockTracker.getBlocksPlaced(player.getUniqueId());
                    Score score = objective.getScore(ChatColor.GRAY + "Blocks placed: ");
                    score.setScore(15);

                    scoreBlank.setScore(14);

                    Score scoreAmount = objective.getScore(ChatColor.GRAY + "" + amount);
                    scoreAmount.setScore(13);

                }catch (Exception exception){

                    Score score = objective.getScore(ChatColor.GRAY + "Blocks placed: ");
                    score.setScore(15);

                    scoreBlank.setScore(14);

                    Score scoreAmount = objective.getScore(ChatColor.GRAY + "" + 0);
                    scoreAmount.setScore(13);

                }

                Score score1 = objective.getScore(ChatColor.LIGHT_PURPLE + "Players online: ");
                score1.setScore(12);

                scoreBlank.setScore(11);

                Score score2 = objective.getScore(ChatColor.LIGHT_PURPLE + "" + Bukkit.getOnlinePlayers().size());
                score2.setScore(10);

                Score scoreDev = objective.getScore(ChatColor.GOLD + "Dev: ");
                scoreDev.setScore(9);

                scoreBlank.setScore(8);

                Score score3 = objective.getScore(ChatColor.GOLD + "max11");
                score3.setScore(7);

                Score scoreDiscord = objective.getScore(ChatColor.AQUA + "Discord: ");
                scoreDiscord.setScore(6);

                scoreBlank.setScore(5);

                Score score4 = objective.getScore(ChatColor.AQUA + "max11#8888");
                score4.setScore(4);

                player.setScoreboard(board);

            }
        }.runTaskTimer(plugin, 0L, 5L);
    }

}
