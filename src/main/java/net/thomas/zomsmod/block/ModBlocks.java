package net.thomas.zomsmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thomas.zomsmod.ZomsMod;
import net.thomas.zomsmod.block.custom.SoundBlock;
import net.thomas.zomsmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ZomsMod.MOD_ID);


    public static final RegistryObject<Block> KRABBY_BLOCK = registerBlock("krabby_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.HONEY_BLOCK)));
    public static final RegistryObject<Block> PURE_BLACK_BLOCK = registerBlock("pure_black_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block", () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));

    public static final RegistryObject<Block> PATTY_BLOCK = registerBlock("patty_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).strength(2f).requiresCorrectToolForDrops(), UniformInt.of(10, 20)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
