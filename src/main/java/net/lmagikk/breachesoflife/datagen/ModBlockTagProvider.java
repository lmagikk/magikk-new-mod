package net.lmagikk.breachesoflife.datagen;

import net.lmagikk.breachesoflife.BreachesOfLife;
import net.lmagikk.breachesoflife.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BreachesOfLife.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLUE_SANDSTONE.get())
                .add(ModBlocks.ODD_BLOCK.get())
                .add(ModBlocks.SCRAPS_BLOCK.get())
                .add(ModBlocks.STRANGE_GROWTH.get())
                .add(ModBlocks.ODD_ORE.get())
                .add(ModBlocks.DEEPSLATE_ODD_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.ODD_LOG.get())
                .add(ModBlocks.ODD_WOOD.get())
                .add(ModBlocks.STRIPPED_ODD_LOG.get())
                .add(ModBlocks.STRIPPED_ODD_WOOD.get())
                .add(ModBlocks.ODD_PLANKS.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ODD_BLOCK.get())
                .add(ModBlocks.SCRAPS_BLOCK.get())
                .add(ModBlocks.ODD_ORE.get())
                .add(ModBlocks.DEEPSLATE_ODD_ORE.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ODD_LOG.get())
                .add(ModBlocks.ODD_WOOD.get())
                .add(ModBlocks.STRIPPED_ODD_LOG.get())
                .add(ModBlocks.STRIPPED_ODD_WOOD.get());


    }
}
