package net.lmagikk.breachesoflife.datagen;

import net.lmagikk.breachesoflife.block.ModBlocks;
import net.lmagikk.breachesoflife.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Map;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {

        dropSelf(ModBlocks.ODD_LOG.get());
        dropSelf(ModBlocks.ODD_WOOD.get());
        dropSelf(ModBlocks.ODD_PLANKS.get());
        dropSelf(ModBlocks.STRIPPED_ODD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_ODD_WOOD.get());
        dropSelf(ModBlocks.ODD_BLOCK.get());
        dropSelf(ModBlocks.SCRAPS_BLOCK.get());
        dropSelf(ModBlocks.BLUE_SAND.get());
        dropSelf(ModBlocks.BLUE_SANDSTONE.get());
        dropSelf(ModBlocks.ODD_SAPLING.get());
        this.add(ModBlocks.ODD_LEAVES.get(), block
                -> createLeavesDrops(block, ModBlocks.ODD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.STRANGE_GROWTH.get(), createSilkTouchOrAlternativeBlockDrop(ModBlocks.STRANGE_GROWTH.get(), Blocks.NETHERRACK));
        this.add(ModBlocks.ODD_GRASS_BLOCK.get(), createSilkTouchOrAlternativeBlockDrop(ModBlocks.ODD_GRASS_BLOCK.get(), ModBlocks.ODD_DIRT.get()));
        dropSelf(ModBlocks.ODD_DIRT.get());

        this.add(ModBlocks.ODD_ORE.get(), block ->
                createOreDrop(ModBlocks.ODD_ORE.get(), ModItems.ODD_SCRAPS.get()));
        this.add(ModBlocks.DEEPSLATE_ODD_ORE.get(), block ->
                createOreDrop(ModBlocks.DEEPSLATE_ODD_ORE.get(), ModItems.ODD_SCRAPS.get()));

    }

    protected LootTable.Builder createMultiupleOreDrops(Block block, Item item, float minDrops, float maxDrops){
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block, this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))))
        );
    }

    protected LootTable.Builder createSilkTouchOrAlternativeBlockDrop(Block block, Block alternativeDrop) {
        HolderLookup.RegistryLookup<net.minecraft.world.item.enchantment.Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        LootPoolEntryContainer.Builder<?> finalAlternativeBuilder = this.applyExplosionDecay(
                block,
                LootItem.lootTableItem(alternativeDrop)
        );
        return this.createSilkTouchDispatchTable(block, finalAlternativeBuilder);
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
