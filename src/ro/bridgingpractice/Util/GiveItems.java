package ro.bridgingpractice.Util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveItems {

    public static void giveOnJoin(Player player){

        Inventory inventory = player.getInventory();

        ItemStack wool = new ItemStack(Material.WOOL, 128 - 1, (byte) 6);

        ItemMeta meta = wool.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_PURPLE + "Bridging Practice!");

        wool.setItemMeta(meta);

        inventory.setItem(0, wool);
        inventory.setItem(1, wool);
        inventory.setItem(2, wool);
        inventory.setItem(3, wool);

    }

}
