package de.artemis.alchemagica.common.world;

import de.artemis.alchemagica.common.registration.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static de.artemis.alchemagica.common.registration.Registration.CONFIGURED_FEATURES;

public class ModConfiguredFeatures {

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
                            BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                            new GeodeCrackSettings(0.95D, 2.0D, 2),
                            0.35D, 0.083D,
                            true,
                            UniformInt.of(4, 6),
                            UniformInt.of(3, 4),
                            UniformInt.of(1, 2),
                            -16, 16, 0.05D, 1)));

    public static void register() {
    }
}
