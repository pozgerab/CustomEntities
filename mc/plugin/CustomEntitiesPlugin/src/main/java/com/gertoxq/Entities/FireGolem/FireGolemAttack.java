package com.gertoxq.Entities.FireGolem;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FireGolemAttack implements Listener {

    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {

        LivingEntity target = (LivingEntity) e.getEntity();
        LivingEntity source = (LivingEntity) e.getDamager();
        if (target.getClass() == FireGolem.class) {

            ((FireGolem) target).setTarget((net.minecraft.world.entity.LivingEntity) source);

            Location targetLoc = target.getLocation();
            Location sourceLoc = source.getLocation();

            if (targetLoc.distance(sourceLoc) <= 16) {

                ((FireGolem) target).incomeHits ++;

                if (((FireGolem) target).incomeHits >= 5) {

                    ((FireGolem) target).magicAttack();
                    ((FireGolem) target).incomeHits = 0;

                }
            }

        }

    }

}
