package com.gertoxq.Entities.FireGolem.AttackEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.behavior.FollowTemptation;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class FireGolemAttackCenter extends Silverfish {

    EntityEquipment armor;
    Location location;

    public FireGolemAttackCenter(EntityType<? extends Silverfish> entitytypes, Level world, Location location, Entity target) {
        super(entitytypes, world);
        this.setTarget((net.minecraft.world.entity.LivingEntity) target);
        this.location = location;
        this.setInvisible(true);
        this.setHealth(10);
        this.armor = ((LivingEntity) this).getEquipment();
        this.armor.setHelmet(new ItemStack(Material.IRON_BLOCK));
        this.setPos(location.getX(), location.getY(), location.getZ());
    }

    protected void initPathfinder() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 3.0, 3.0F));
    }

}
