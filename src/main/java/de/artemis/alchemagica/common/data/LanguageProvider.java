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

        add("tooltip.alchemagica.arcane_pickaxe", "Use this Arcane Pickaxe to gather Marvelous Ancient Petal Fragments from Ancient Petal Clusters");
        add("tooltip.alchemagica.arcane_shears", "Use this Arcane Shears to gather more petals from blossoms if they are growing on Arcane Soil. You also don't have to destroy them each time");
        add("tooltip.alchemagica.arcane_hoe", "Use this Arcane Hoe to turn dirt and other similar blocks into Arcane Soil, further enhancing growth and irigation");

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
    }
}
