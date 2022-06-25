package com.gertoxq.Entities.FireGolem.AttackEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.Level;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class FireGolemAttackParticles extends ArmorStand {

    EntityEquipment armor;
    Location location;

    public FireGolemAttackParticles(EntityType<? extends ArmorStand> entitytypes, Level world, Location location, FireGolemAttackCenter parent) {
        super(entitytypes, world);
        this.location = location;
        this.setInvisible(true);
        this.setMarker(true);
        this.armor = ((LivingEntity) this).getEquipment();
        this.armor.setHelmet(new ItemStack(Material.REDSTONE_BLOCK));
        this.setPos(location.getX(), location.getY(), location.getZ());
        ((org.bukkit.entity.ArmorStand) this).setRotation(0,0);

    }

}
