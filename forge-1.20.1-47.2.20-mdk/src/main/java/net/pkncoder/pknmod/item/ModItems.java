package net.pkncoder.pknmod.item;

import net.pkncoder.pknmod.PknMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, PknMod.MOD_ID);

        public static final RegistryObject<Item> CHILD = ITEMS.register("child",
        () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> FLAMING_CHILD = ITEMS.register("flaming_child",
        () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> REDSTONE_INGOT = ITEMS.register("redstone_ingot", 
        () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}