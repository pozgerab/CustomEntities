package com.gertoxq.customentity.item;

import com.gertoxq.customentity.CustomEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CustomEntity.MOD_ID);

    public static final RegistryObject<Item> VOID_CORE = ITEMS.register("void_core",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CUSTOM_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
