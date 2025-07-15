package net.lmagikk.breachesoflife.datagen;

import net.lmagikk.breachesoflife.BreachesOfLife;
import net.lmagikk.breachesoflife.block.ModBlocks;
import net.lmagikk.breachesoflife.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BreachesOfLife.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModItems.ODD_SCRAPS.get());
        basicItem(ModItems.ODD_BAR.get());

        saplingItem(ModBlocks.ODD_SAPLING);

    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(BreachesOfLife.MOD_ID, "block/" + item.getId().getPath()));
    }
}
