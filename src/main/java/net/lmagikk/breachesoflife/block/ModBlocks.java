package net.lmagikk.breachesoflife.block;

import net.lmagikk.breachesoflife.BreachesOfLife;
import net.lmagikk.breachesoflife.block.custom.ModFlammableRotatedPillarBlock;
import net.lmagikk.breachesoflife.block.custom.ModSaplingBlock;
import net.lmagikk.breachesoflife.item.ModItems;
import net.lmagikk.breachesoflife.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.*;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BreachesOfLife.MOD_ID);

    public static final DeferredBlock<Block> ODD_BLOCK = registerBlock("odd_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(5f)
            .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SCRAPS_BLOCK = registerBlock("block_of_scraps",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(6f)
            .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLUE_SAND = registerBlock("blue_sand",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(2f)));

    public static final DeferredBlock<Block> BLUE_SANDSTONE = registerBlock("blue_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(2f)
            .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ODD_PLANKS = registerBlock("odd_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> ODD_LEAVES = registerBlock("odd_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> ODD_LOG = registerBlock("odd_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> ODD_WOOD = registerBlock("odd_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_ODD_LOG = registerBlock("stripped_odd_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_ODD_WOOD = registerBlock("stripped_odd_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> ODD_SAPLING = registerBlock("odd_sapling",
            () -> new ModSaplingBlock(ModTreeGrowers.ODD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), state ->
                    state.is(ModBlocks.ODD_GRASS_BLOCK) ||
                    state.is(ModBlocks.ODD_DIRT)
            ));

    public static final DeferredBlock<Block> STRANGE_GROWTH = registerBlock("strange_growth",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_NYLIUM)));

    public static final DeferredBlock<Block> ODD_GRASS_BLOCK = registerBlock("odd_grass_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<Block> ODD_DIRT = registerBlock("odd_dirt",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final DeferredBlock<Block> ODD_ORE = registerBlock("odd_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE)));
    public static final DeferredBlock<Block> DEEPSLATE_ODD_ORE = registerBlock("deepslate_odd_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE)));




    private static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItme(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItme(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
