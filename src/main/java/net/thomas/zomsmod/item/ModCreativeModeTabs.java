package net.thomas.zomsmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.thomas.zomsmod.ZomsMod;
import net.thomas.zomsmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ZomsMod.MOD_ID);

    //CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KRABBY_PATTY.get() sets the icon for the creative tab
    public static final RegistryObject<CreativeModeTab> ZOMS_TAB = CREATIVE_MODE_TABS.register("zoms_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KRABBY_PATTY.get()))
                    .title(Component.translatable("creativetab.zoms_mod"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Add items to creative tab
                        output.accept(ModItems.KRABBY_PATTY.get());
                        output.accept(ModItems.LETTUCE.get());
                        output.accept(ModItems.JUGGERNOG.get());
                        output.accept(ModItems.SPEED_COLA.get());
                        output.accept(ModItems.QUICK_REVIVE.get());

                        // you can also add Vanilla items to the list
                        output.accept(Items.DIAMOND);

                        // Add blocks to creative tab
                        output.accept(ModBlocks.KRABBY_BLOCK.get());
                        output.accept(ModBlocks.PURE_BLACK_BLOCK.get());
                        output.accept(ModBlocks.SOUND_BLOCK.get());
                        output.accept(ModBlocks.PATTY_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
