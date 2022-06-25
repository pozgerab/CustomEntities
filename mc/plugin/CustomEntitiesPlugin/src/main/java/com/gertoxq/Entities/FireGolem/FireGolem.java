package com.gertoxq.Entities.FireGolem;

import net.minecraft.world.entity.animal.IronGolem;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftIronGolem;
import org.bukkit.entity.Entity;

public class FireGolem extends CraftIronGolem {

    public FireGolem(CraftServer server, IronGolem entity) {
        super(server, entity);
        this.setMaxHealth(200);
        this.setHealth(200);
    }
    public void attack() {

    }
}



