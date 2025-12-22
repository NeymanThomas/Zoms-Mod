package net.thomas.zomsmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thomas.zomsmod.ZomsMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZomsMod.MOD_ID);

    public static final RegistryObject<Item> KRABBY_PATTY = ITEMS.register("krabby_patty", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JUGGERNOG = ITEMS.register("juggernog", () -> new CustomFoodItem(new Item.Properties().food(ModFoods.JUGGERNOG).stacksTo(1), "tooltip.zomsmod.juggernog"));
    public static final RegistryObject<Item> SPEED_COLA = ITEMS.register("speed_cola", () -> new CustomFoodItem(new Item.Properties().food(ModFoods.SPEED_COLA).stacksTo(1), "tooltip.zomsmod.speed_cola"));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
