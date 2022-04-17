package me.fakado.damagechecker.onDamage;

import me.fakado.damagechecker.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class onDamage implements Listener {

    private Main plugin;

    public onDamage (Main plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin); // DO NOT, AND I MEAN IT!! DO NOT REMOVE THIS PART.
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
       var damager = e.getDamager().getType(); // The damager... duhh
       var damaged = e.getEntityType(); // The one who got damaged or hit

        // We need to check some things such as if user got hit by a real player or a mob...
       if(damager == EntityType.PLAYER) {
           if(damaged == EntityType.PLAYER){
               if(damager == EntityType.ARROW) {
                   e.setDamage(0);
               }
               else {
                   e.setDamage(0);
               }
           }
           else return;
       }
    }

}
