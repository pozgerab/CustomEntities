package com.gertoxq.Entities.FireGolem;

import com.gertoxq.Customentities;
import com.gertoxq.Entities.FireGolem.AttackEntity.FireGolemAttackCenter;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;

import java.util.List;

public class FireGolem extends IronGolem {

    public final Customentities plugin = Customentities.getPlugin();

    Integer incomeHits;
    List<FireGolemAttackCenter> attacks;

    public FireGolem(EntityType<? extends IronGolem> entitytypes, Level world) {
        super(entitytypes, world);
        this.setHealth(200);
        this.incomeHits = 0;
    }


    public void magicAttack() {
        Location targetLoc = this.getTarget().getBukkitEntity().getLocation();
        Location missileLoc = new Location(targetLoc.getWorld(), Math.random()*5, targetLoc.getY(), Math.random()*6);
        targetLoc.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, missileLoc, 1);
        ((Level) targetLoc.getWorld()).addFreshEntity(new FireGolemAttackCenter(EntityType.SILVERFISH, (Level) targetLoc.getWorld(), missileLoc, this.getTarget()));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

        }, 0L, 1L);
    }

    protected void initPathfinder() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 1.0F));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 1.0, 1.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }
}



