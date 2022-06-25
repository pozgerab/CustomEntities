package com.gertoxq.Entities.FireGolem;

import com.gertoxq.Customentities;
import com.gertoxq.Entities.FireGolem.AttackEntity.FireGolemAttackCenter;
import com.gertoxq.Entities.FireGolem.AttackEntity.FireGolemAttackParticles;
import net.minecraft.world.entity.animal.IronGolem;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftIronGolem;
import org.bukkit.entity.Entity;

import java.util.List;

public class FireGolem extends CraftIronGolem {

    public final Customentities plugin = Customentities.getPlugin();

    Integer incomeHits;
    List<FireGolemAttackCenter> attacks;

    public FireGolem(CraftServer server, IronGolem entity) {
        super(server, entity);
        this.setMaxHealth(200);
        this.setHealth(200);
        this.incomeHits = 0;

    }
    public void magicAttack() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

        }, 0L, 1L);
    }
}



