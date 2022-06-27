package com.gertoxq;

import com.gertoxq.Entities.FireGolem.FireGolem;
import net.minecraft.advancements.critereon.EnchantedItemTrigger;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public final class Customentities extends JavaPlugin {

    static Customentities plugin;

    public static Customentities getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        World world = Bukkit.getWorlds().get(0);
        FireGolem fireGolem = new FireGolem(EntityType.IRON_GOLEM,(Level) world);
        ((Level) world).addFreshEntity(fireGolem);
        // Plugin startup logic

    }

}
