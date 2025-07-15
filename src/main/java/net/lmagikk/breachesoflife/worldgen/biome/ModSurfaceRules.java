package net.lmagikk.breachesoflife.worldgen.biome;

import net.lmagikk.breachesoflife.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource BLUE_SANDSTONE = makeStateRule(ModBlocks.BLUE_SANDSTONE.get());
    private static final SurfaceRules.RuleSource BLUE_SAND = makeStateRule(ModBlocks.BLUE_SAND.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource ODD_DIRT = makeStateRule(ModBlocks.ODD_DIRT.get());
    private static final SurfaceRules.RuleSource ODD_GRASS_BLOCK = makeStateRule(ModBlocks.ODD_GRASS_BLOCK.get());


    public static SurfaceRules.RuleSource makeOddForestRules() {

        BlockState grass = ModBlocks.ODD_GRASS_BLOCK.get().defaultBlockState();
        BlockState dirt = ModBlocks.ODD_DIRT.get().defaultBlockState();

        return SurfaceRules.sequence(

                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(ModBiomes.ODD_FOREST),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.stoneDepthCheck(0, false,0, CaveSurface.FLOOR ),
                                        SurfaceRules.state(grass)),



                                SurfaceRules.state(dirt))
                )

        );

    }

    public static SurfaceRules.RuleSource makeCorruptWoodsRules() {

        BlockState nylium = ModBlocks.STRANGE_GROWTH.get().defaultBlockState();
        BlockState netherrack = Blocks.NETHERRACK.defaultBlockState();

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK),
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK),

                // Then apply biome-specific rules
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(ModBiomes.CORRUPT_WOODS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.stoneDepthCheck(0, false,0, CaveSurface.FLOOR ),
                                        SurfaceRules.state(nylium)),



                SurfaceRules.state(netherrack))
                )
        );
    }

    public static SurfaceRules.RuleSource makeBlueDesertRules() {


        return SurfaceRules.sequence(

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.BLUE_DESERT),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, BLUE_SAND), BLUE_SANDSTONE)),
                // Default to green terracotta
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, STONE)


        );
    }

        private static SurfaceRules.RuleSource makeStateRule(Block block) {
            return SurfaceRules.state(block.defaultBlockState());

    }
    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double value) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, value / 8.25, Double.MAX_VALUE);
    }

}
