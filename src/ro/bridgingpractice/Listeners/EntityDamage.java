package ro.bridgingpractice.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){

        if(!(event.getEntity() instanceof Player)) return;

        if(!(event.getCause() == EntityDamageEvent.DamageCause.FALL)) return;

        event.setCancelled(true);

    }

}
