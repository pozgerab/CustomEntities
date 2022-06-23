package com.gertoxq.customentity.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab CUSTOM_TAB = new CreativeModeTab("customtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.VOID_CORE.get());
        }
    };
}
