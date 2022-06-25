package com.gertoxq.Entities.FireGolem;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FireGolemTarget implements Listener {

    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        LivingEntity target = (LivingEntity) e.getEntity();
        LivingEntity source = (LivingEntity) e.getDamager();

        if (target.getClass() == FireGolem.class) {
            ((FireGolem) target).setTarget(source);
        }
    }

}
