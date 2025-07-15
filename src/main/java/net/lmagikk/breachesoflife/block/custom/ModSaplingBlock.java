package net.lmagikk.breachesoflife.block.custom;

import net.lmagikk.breachesoflife.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ModSaplingBlock extends SaplingBlock {

    private final Predicate<BlockState> validGround;
    public ModSaplingBlock(TreeGrower treeGrower, Properties properties, Predicate<BlockState> validGround) {
        super(treeGrower, properties);
        this.validGround = validGround;

    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        BlockState groundtate = pLevel.getBlockState(pPos.below());
        return this.validGround.test(groundtate);
    }
}
