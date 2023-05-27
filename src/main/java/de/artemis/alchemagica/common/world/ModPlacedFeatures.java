package de.artemis.alchemagica.common.world;

import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static de.artemis.alchemagica.common.registration.Registration.PLACED_FEATURES;

public class ModPlacedFeatures {

    public static final RegistryObject<PlacedFeature> ARCANE_CRYSTAL_GEODE = PLACED_FEATURES.register("arcane_crystal_geode_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ARCANE_CRYSTAL_GEODE.getHolder().get(), List.of(
                    RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(30)),
                    BiomeFilter.biome())));

    public static void register() {
    }
}
