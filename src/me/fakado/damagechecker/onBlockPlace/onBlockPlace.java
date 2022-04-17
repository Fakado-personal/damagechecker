package me.fakado.damagechecker.onBlockPlace;

import me.fakado.damagechecker.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;
import java.util.logging.Logger;

public class onBlockPlace implements Listener {

    private Main plugin;

    public onBlockPlace(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin); // DO NOT, AND I MEAN IT!! DO NOT REMOVE THIS PART.
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        var blockType = e.getBlockPlaced().getType().name();

        if (blockType == "MAGMA_BLOCK" || blockType == "TNT") {
            var p = e.getPlayer();
            for (Entity nearby : p.getNearbyEntities(10, 10, 10)) {
                if (nearby instanceof Player) {
                    e.getBlock().breakNaturally();
                    p.sendMessage("You are not allowed to place those blocks near someone.");
                    Logger log = Bukkit.getLogger();
                    log.info(e.getPlayer().getDisplayName() + " tried to place a forbidden block near another player.");
                } else return;

            }

        }
    }
}
