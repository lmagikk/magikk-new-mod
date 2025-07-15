package net.lmagikk.breachesoflife.item;

import net.lmagikk.breachesoflife.BreachesOfLife;
import net.lmagikk.breachesoflife.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BreachesOfLife.MOD_ID);

    public static final Supplier<CreativeModeTab> BREACHESOFLIFETAB = CREATIVE_MODE_TABS.register("boltab", () -> CreativeModeTab.builder()
            .title(Component.translatable("bol.creative.tab"))
            .icon(() -> new ItemStack(ModItems.ODD_SCRAPS.get()))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.ODD_SCRAPS);
                pOutput.accept(ModItems.ODD_BAR);
                pOutput.accept(ModBlocks.ODD_BLOCK);
                pOutput.accept(ModBlocks.SCRAPS_BLOCK);
                pOutput.accept(ModBlocks.BLUE_SAND);
                pOutput.accept(ModBlocks.BLUE_SANDSTONE);
                pOutput.accept(ModBlocks.ODD_LOG);
                pOutput.accept(ModBlocks.STRIPPED_ODD_LOG);
                pOutput.accept(ModBlocks.ODD_PLANKS);
                pOutput.accept(ModBlocks.ODD_SAPLING);
                pOutput.accept(ModBlocks.ODD_WOOD);
                pOutput.accept(ModBlocks.STRIPPED_ODD_WOOD);
                pOutput.accept(ModBlocks.STRANGE_GROWTH);
                pOutput.accept(ModBlocks.ODD_GRASS_BLOCK);
                pOutput.accept(ModBlocks.ODD_DIRT);
                pOutput.accept(ModBlocks.ODD_ORE);
                pOutput.accept(ModBlocks.DEEPSLATE_ODD_ORE);

            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
