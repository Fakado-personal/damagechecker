package me.fakado.damagechecker;

import me.fakado.damagechecker.onDamage.onDamage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        Logger log = Bukkit.getLogger();
        log.info("Damage Checker by Fakado has loaded!!");

        new onDamage(this);
   }
}