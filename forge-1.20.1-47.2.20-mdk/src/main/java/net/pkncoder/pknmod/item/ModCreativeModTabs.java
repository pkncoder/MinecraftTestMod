package net.pkncoder.pknmod.item;

import net.pkncoder.pknmod.PknMod;
import net.pkncoder.pknmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PknMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("creative_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHILD.get()))
                    .title(Component.translatable("creativetab.creative_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.FLAMING_CHILD.get());
                        pOutput.accept(ModItems.CHILD.get());
                        pOutput.accept(ModItems.REDSTONE_INGOT.get());
                        pOutput.accept(ModBlocks.PURE_REDSTONE_BLOCK.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}