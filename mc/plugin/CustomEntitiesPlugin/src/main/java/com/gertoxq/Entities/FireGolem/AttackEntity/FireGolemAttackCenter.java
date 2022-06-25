package com.gertoxq.Entities.FireGolem.AttackEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.Level;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class FireGolemAttackCenter extends ArmorStand {

    EntityEquipment armor;
    Location location;
    List<FireGolemAttackParticles> particles;

    public FireGolemAttackCenter(EntityType<? extends ArmorStand> entitytypes, Level world, Location location) {
        super(entitytypes, world);
        this.location = location;
        this.setInvisible(true);
        this.setMarker(true);
        this.armor = ((LivingEntity) this).getEquipment();
        this.armor.setHelmet(new ItemStack(Material.IRON_BLOCK));
        this.setPos(location.getX(), location.getY(), location.getZ());
    }

}
