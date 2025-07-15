package net.lmagikk.breachesoflife.worldgen.biome;


import net.lmagikk.breachesoflife.BreachesOfLife;
import net.lmagikk.breachesoflife.worldgen.biome.region.NetherRegion;
import net.lmagikk.breachesoflife.worldgen.biome.region.OverworldRegion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.RegionType;
import terrablender.api.Regions;

public class ModBiomes {
    public static final ResourceKey<Biome> ODD_FOREST = registerBiomeKey("odd_forest");
    public static final ResourceKey<Biome> CORRUPT_WOODS = registerBiomeKey("corrupt_woods");
    public static final ResourceKey<Biome> BLUE_DESERT = registerBiomeKey("blue_desert");

    public static void registerBiomes() {
        Regions.register(new OverworldRegion(ResourceLocation.fromNamespaceAndPath(BreachesOfLife.MOD_ID, "biomes_overworld"), RegionType.OVERWORLD, 10));
        Regions.register(new NetherRegion(ResourceLocation.fromNamespaceAndPath(BreachesOfLife.MOD_ID, "biomes_nether"), RegionType.NETHER, 10));
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        var carver = context.lookup(Registries.CONFIGURED_CARVER);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, ODD_FOREST, ModOverworldBiomes.oddForest(placedFeatures, carver));
        register(context, CORRUPT_WOODS, ModNetherBiomes.corruptWoods(placedFeatures, carver));
        register(context, BLUE_DESERT, ModOverworldBiomes.blueDesert(placedFeatures, carver));
    }


    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }

    private static ResourceKey<Biome> registerBiomeKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(BreachesOfLife.MOD_ID, name));
    }
}