package net.thomas.zomsmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.thomas.zomsmod.ZomsMod;
import net.thomas.zomsmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ZomsMod.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
        simpleItem(ModItems.KRABBY_PATTY);
        simpleItem(ModItems.LETTUCE);
        simpleItem(ModItems.JUGGERNOG);
        simpleItem(ModItems.SPEED_COLA);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
        ResourceLocation.tryParse("item/generated")).texture("layer0", ResourceLocation.tryBuild(ZomsMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
