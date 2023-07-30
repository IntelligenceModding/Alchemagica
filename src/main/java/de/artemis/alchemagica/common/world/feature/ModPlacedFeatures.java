package de.artemis.alchemagica.common.world.feature;

import de.artemis.alchemagica.common.registration.ModBlocks;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static de.artemis.alchemagica.common.registration.Registration.PLACED_FEATURES;

public class ModPlacedFeatures {

    public static final RegistryObject<PlacedFeature> ANCIENT_PETAL_CLUSTER_PLACED = PLACED_FEATURES.register("ancient_petal_cluster_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ANCIENT_PETAL_CLUSTER.getHolder().get(),
                    commonOrePlacement(30, // Amount of ore veins per chunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> ARCANE_CRYSTAL_GEODE = PLACED_FEATURES.register("arcane_crystal_geode_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ARCANE_CRYSTAL_GEODE.getHolder().get(), List.of(
                    RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(30)),
                    BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> ARCANE_TREE_CHECKED = PLACED_FEATURES.register("arcane_tree_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.ARCANE_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.ARCANE_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> ARCANE_TREE_PLACED = PLACED_FEATURES.register("arcane_tree_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ARCANE_TREE_SPAWN.getHolder().get(),
                    VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register() {
    }
}
