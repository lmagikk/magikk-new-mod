package net.lmagikk.breachesoflife.datagen;

import net.lmagikk.breachesoflife.BreachesOfLife;
import net.lmagikk.breachesoflife.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BreachesOfLife.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ODD_BLOCK);
        blockWithItem(ModBlocks.SCRAPS_BLOCK);
        blockWithItem(ModBlocks.BLUE_SAND);
        blockWithItem(ModBlocks.ODD_DIRT);


        logBlock(((RotatedPillarBlock) ModBlocks.ODD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.ODD_WOOD.get()),
                blockTexture(ModBlocks.ODD_LOG.get()), blockTexture(ModBlocks.ODD_LOG.get()));

        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ODD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ODD_WOOD.get()),
                blockTexture(ModBlocks.STRIPPED_ODD_LOG.get()), blockTexture(ModBlocks.STRIPPED_ODD_LOG.get()));

        blockItem(ModBlocks.ODD_LOG);
        blockItem(ModBlocks.ODD_WOOD);
        blockItem(ModBlocks.STRIPPED_ODD_LOG);
        blockItem(ModBlocks.STRIPPED_ODD_WOOD);

        blockWithItem(ModBlocks.ODD_PLANKS);

        leavesBlock(ModBlocks.ODD_LEAVES);

        saplingBlock(ModBlocks.ODD_SAPLING);

        sandstoneBlock(ModBlocks.BLUE_SANDSTONE);

        strangeGrowth(ModBlocks.STRANGE_GROWTH);

        oddGrass(ModBlocks.ODD_GRASS_BLOCK);

        blockWithItem(ModBlocks.ODD_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ODD_ORE);








    }

    private void oddGrass(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeBottomTop(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                        ResourceLocation.parse("breachesoflife:block/odd_grass_block"),
                        ResourceLocation.parse("breachesoflife:block/odd_dirt"),
                        ResourceLocation.parse("breachesoflife:block/odd_grass_block_top")));
    }


    private void strangeGrowth(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeBottomTop(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                        ResourceLocation.parse("breachesoflife:block/strange_growth_side"),
                        ResourceLocation.parse("minecraft:block/netherrack"),
                        ResourceLocation.parse("breachesoflife:block/strange_growth")));
    }

    private void sandstoneBlock(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(),
                models().cubeBottomTop(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                        ResourceLocation.parse("breachesoflife:block/blue_sandstone"),
                        ResourceLocation.parse("breachesoflife:block/blue_sandstone_bottom"),
                        ResourceLocation.parse("breachesoflife:block/blue_sandstone_top")));
    }

    private void leavesBlock(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                        ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));

    }

    private void saplingBlock(DeferredBlock<Block> deferredBlock){
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(),
                blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("breachesoflife:block/" + deferredBlock.getId().getPath()));
    }

}
