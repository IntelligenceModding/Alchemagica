package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import net.minecraft.data.DataGenerator;

public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider{

    public LanguageProvider(DataGenerator gen, String locale) {
        super(gen, Alchemagica.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.alchemagica", "Alchemagica");

        add("keybind.alchemagica.category", "Alchemagica");
        add("keybind.alchemagica.toggle_description_keybind", "Show Description");

        add("tooltip.alchemagica.arcane_pickaxe", "Use this Arcane Pickaxe to gather Marvelous Ancient Petal Fragments from Ancient Petal Clusters, as well as Budding Arcane Crystals");
        add("tooltip.alchemagica.arcane_shears", "Use this Arcane Shears to gather more petals from blossoms if they are growing on Arcane Soil. You also don't have to destroy them each time");
        add("tooltip.alchemagica.arcane_hoe", "Use this Arcane Hoe to turn dirt and other similar blocks into Arcane Soil, further enhancing growth and irrigation");
        add("tooltip.alchemagica.arcane_axe", "Use this Arcane Axe to gather Bark from any tree, as well as Arcane Bark from Arcane Trees.");

        add("displayname.alchemagica.mortar_and_pestle_block_entity", "Mortar And Pestle");
        add("displayname.alchemagica.centrifuge_block_entity", "Centrifuge");

        add(ModItems.ARCANE_BLOSSOM_SEED.get(), "Arcane Blossom Seed");
        add(ModItems.ARCANE_BLOSSOM_PETAL.get(), "Arcane Blossom Petal");
        add(ModItems.CRUSHED_ARCANE_BLOSSOM_PETAL.get(), "Crushed Arcane Blossom Petal");
        add(ModItems.ARCANE_BLOSSOM_EXTRACT.get(), "Arcane Blossom Extract");
        add(ModItems.ARCANE_CRYSTAL_SHARD.get(), "Arcane Crystal Shard");
        add(ModItems.ARCANE_SHEARS.get(), "Arcane Shears");
        add(ModItems.ARCANE_CRYSTAL_POWDER.get(), "Arcane Crystal Powder");
        add(ModItems.ANCIENT_PETAL_FRAGMENT.get(), "Ancient Petal Fragment");
        add(ModItems.MARVELOUS_ANCIENT_PETAL_FRAGMENT.get(), "Marvelous Ancient Petal Fragment");
        add(ModItems.ARCANE_PICKAXE.get(), "Arcane Pickaxe");
        add(ModItems.ARCANE_HOE.get(), "Arcane Hoe");
        add(ModItems.ARCANE_AXE.get(), "Arcane Axe");
        add(ModItems.ARCANE_SIGN.get(), "Arcane Sign");
        add(ModItems.OAK_BARK.get(), "Oak Bark");
        add(ModItems.BIRCH_BARK.get(), "Birch Bark");
        add(ModItems.SPRUCE_BARK.get(), "Spruce Bark");
        add(ModItems.DARK_OAK_BARK.get(), "Dark Oak Bark");
        add(ModItems.JUNGLE_BARK.get(), "Jungle Bark");
        add(ModItems.ACACIA_BARK.get(), "Acacia Bark");
        add(ModItems.MANGROVE_BARK.get(), "Mangrove Bark");
        add(ModItems.CRIMSON_BARK.get(), "Crimson Bark");
        add(ModItems.WARPED_BARK.get(), "Warped Bark");
        add(ModItems.ARCANE_BARK.get(), "Arcane Bark");
        add(ModItems.ARCANE_STICK.get(), "Arcane Stick");

        add(ModBlocks.ARCANE_BLOSSOM.get(), "Arcane Blossom");
        add(ModBlocks.ANCIENT_PETAL_CLUSTER.get(), "Ancient Petal Cluster");
        add(ModBlocks.ARCANE_CRYSTAL_BLOCK.get(), "Arcane Crystal Block");
        add(ModBlocks.BUDDING_ARCANE_CRYSTAL.get(), "Budding Arcane Crystal");
        add(ModBlocks.ARCANE_CRYSTAL_CLUSTER.get(), "Arcane Crystal Cluster");
        add(ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get(), "Large Arcane Crystal Bud");
        add(ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get(), "Medium Arcane Crystal Bud");
        add(ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get(), "Small Arcane Crystal Bud");
        add(ModBlocks.ARCANE_SOIL.get(), "Arcane Soil");
        add(ModBlocks.MORTAR_AND_PESTLE.get(), "Mortar And Pestle");
        add(ModBlocks.CENTRIFUGE.get(), "Centrifuge");
        add(ModBlocks.ARCANE_PLANKS.get(), "Arcane Planks");
        add(ModBlocks.ARCANE_SAPLING.get(), "Arcane Sapling");
        add(ModBlocks.ARCANE_LOG.get(), "Arcane Log");
        add(ModBlocks.STRIPPED_ARCANE_LOG.get(), "Stripped Arcane Log");
        add(ModBlocks.ARCANE_WOOD.get(), "Arcane Wood");
        add(ModBlocks.STRIPPED_ARCANE_WOOD.get(), "Stripped Arcane Wood");
        add(ModBlocks.ARCANE_LEAVES.get(), "Arcane Leaves");
        add(ModBlocks.ARCANE_PRESSURE_PLATE.get(), "Arcane Pressure Plate");
        add(ModBlocks.ARCANE_TRAPDOOR.get(), "Arcane Trapdoor");
        add(ModBlocks.ARCANE_STAIRS.get(), "Arcane Stairs");
        add(ModBlocks.ARCANE_BUTTON.get(), "Arcane Button");
        add(ModBlocks.ARCANE_SLAB.get(), "Arcane Slab");
        add(ModBlocks.ARCANE_FENCE_GATE.get(), "Arcane Fence Gate");
        add(ModBlocks.ARCANE_FENCE.get(), "Arcane Fence");
        add(ModBlocks.ARCANE_DOOR.get(), "Arcane Door");
    }
}
