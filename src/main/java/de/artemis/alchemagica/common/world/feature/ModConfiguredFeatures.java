package de.artemis.alchemagica.common.world.feature;

import com.google.common.base.Suppliers;
import de.artemis.alchemagica.common.registration.ModBlocks;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

import static de.artemis.alchemagica.common.registration.Registration.CONFIGURED_FEATURES;

public class ModConfiguredFeatures {

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ANCIENT_PETAL_CLUSTER = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ANCIENT_PETAL_CLUSTER.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ANCIENT_PETAL_CLUSTER = CONFIGURED_FEATURES.register("ancient_petal_cluster",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ANCIENT_PETAL_CLUSTER.get(), 15))); // pSize is the vein size of this ore

    public static final RegistryObject<ConfiguredFeature<?, ?>> ARCANE_CRYSTAL_GEODE = CONFIGURED_FEATURES.register("arcane_crystal_geode",
            () -> new ConfiguredFeature<>(Feature.GEODE,
                    new GeodeConfiguration(new GeodeBlockSettings(
                            BlockStateProvider.simple(Blocks.AIR),
                            BlockStateProvider.simple(ModBlocks.ARCANE_CRYSTAL_BLOCK.get()),
                            BlockStateProvider.simple(ModBlocks.BUDDING_ARCANE_CRYSTAL.get()),
                            BlockStateProvider.simple(Blocks.CALCITE),
                            BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                            List.of(ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get().defaultBlockState(),
                                    ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get().defaultBlockState(),
                                    ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get().defaultBlockState(),
                                    ModBlocks.ARCANE_CRYSTAL_CLUSTER.get().defaultBlockState()),
                            BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ARCANE_TREE =
            CONFIGURED_FEATURES.register("arcane_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.ARCANE_LOG.get()),
                            new ForkingTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(ModBlocks.ARCANE_LEAVES.get()),
                            new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ARCANE_TREE_SPAWN =
            CONFIGURED_FEATURES.register("arcane_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.ARCANE_TREE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.ARCANE_TREE_CHECKED.getHolder().get())));

    public static void register() {
    }
}
