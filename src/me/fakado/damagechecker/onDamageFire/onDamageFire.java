package me.fakado.damagechecker.onDamageFire;

import me.fakado.damagechecker.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class onDamageFire implements Listener {

    private Main plugin;

    public onDamageFire (Main plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin); // DO NOT, AND I MEAN IT!! DO NOT REMOVE THIS PART.
    }

    @EventHandler
    public void onDamageFire(EntityDamageEvent e){
       var cause = e.getCause();
       if(cause == EntityDamageEvent.DamageCause.FIRE || cause == EntityDamageEvent.DamageCause.FIRE_TICK || cause == EntityDamageEvent.DamageCause.LAVA)
       {
           e.setDamage(0);
       }
       else return;
    }

}
