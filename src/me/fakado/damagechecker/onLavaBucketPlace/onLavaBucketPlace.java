package me.fakado.damagechecker.onLavaBucketPlace;

import me.fakado.damagechecker.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Logger;

public class onLavaBucketPlace implements Listener {

    private Main plugin;

    public onLavaBucketPlace(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin); // DO NOT, AND I MEAN IT!! DO NOT REMOVE THIS PART.
    }

    @EventHandler
    public void onLavaBucketPlace(PlayerBucketEmptyEvent e) {
        var b = e.getBucket();
        if(b == Material.LAVA_BUCKET) {
            var p = e.getPlayer();
            for (Entity nearby : p.getNearbyEntities(10, 10, 10)) {
                if (nearby instanceof Player) {
                    e.setCancelled(true);
                    p.sendMessage("You are not allowed to place a lava bucket near another player!");
                    Logger log = Bukkit.getLogger();
                    log.info(e.getPlayer().getDisplayName() + " tried to place a forbidden block near another player.");
                }
            }
        }
        else return;
    }
}
