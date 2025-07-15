package net.lmagikk.breachesoflife.worldgen.tree;

import net.lmagikk.breachesoflife.BreachesOfLife;
import net.lmagikk.breachesoflife.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower ODD = new TreeGrower(BreachesOfLife.MOD_ID + "odd",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ODD_TREE_KEY), Optional.empty());
}
