package com.gertoxq;

import com.gertoxq.Entities.FireGolem.FireGolem;
import net.minecraft.advancements.critereon.EnchantedItemTrigger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public final class Customentities extends JavaPlugin {

    Customentities plugin;

    public Customentities getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        World world = Bukkit.getWorlds().get(0);
        world.spawn(new Location(world,0,0,0), FireGolem.class);
        // Plugin startup logic

    }

}
