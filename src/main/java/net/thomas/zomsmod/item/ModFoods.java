package net.thomas.zomsmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties JUGGERNOG = new FoodProperties.Builder().nutrition(2).alwaysEat().saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION), 1f).build();
    public static final FoodProperties SPEED_COLA = new FoodProperties.Builder().nutrition(0).alwaysEat().saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED), 1f).build();
}
