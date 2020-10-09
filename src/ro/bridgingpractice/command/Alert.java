package ro.bridgingpractice.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ro.bridgingpractice.Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alert implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("alert")){

            if(!(sender.hasPermission("bp.alert"))){

                sender.sendMessage(Util.noPermissions);

                return false;

            }

            List<String> words = new ArrayList<>();

            String message = null;

            words.addAll(Arrays.asList(args));



        }

        return false;
    }
}
