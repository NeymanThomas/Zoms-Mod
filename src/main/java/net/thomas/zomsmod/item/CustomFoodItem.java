package net.thomas.zomsmod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomFoodItem extends Item {

    private final String tooltipKey;

    public CustomFoodItem(Properties properties, String tooltipKey) {
        super(properties);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && pLivingEntity instanceof Player player) {

            // Juggernog
            if (pStack.is(ModItems.JUGGERNOG.get())) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.ABSORPTION,
                        MobEffectInstance.INFINITE_DURATION,
                        0,
                        false,
                        false,
                        true
                ));
            }

            // Speed Cola
            if (pStack.is(ModItems.SPEED_COLA.get())) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.MOVEMENT_SPEED,
                        MobEffectInstance.INFINITE_DURATION,
                        1,
                        false,
                        false,
                        true
                ));
            }
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        // Change the color of the tooltip text depending on what item it is
        if (tooltipKey.contains("juggernog")) {
            pTooltipComponents.add(Component.translatable(tooltipKey).withStyle(ChatFormatting.RED));
        } else if (tooltipKey.contains("speed_cola")) {
            pTooltipComponents.add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GREEN));
        } else {
            pTooltipComponents.add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
