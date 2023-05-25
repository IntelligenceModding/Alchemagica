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

        add("tooltip.alchemagica.arcanepickaxe", "Use this Arcane Pickaxe to gather Marvelous Ancient Petal Fragments from Ancient Petal Clusters");
        add("tooltip.alchemagica.arcaneshears", "Use this Arcane Shears to gather petals from blossoms without the need to destroy them");

        add(ModItems.ARCANE_BLOSSOM_SEED.get(), "Arcane Blossom Seed");
        add(ModItems.ARCANE_BLOSSOM_PETAL.get(), "Arcane Blossom Petal");
        add(ModItems.ARCANE_SHARD.get(), "Arcane Shard");
        add(ModItems.ARCANE_SHEARS.get(), "Arcane Shears");
        add(ModItems.ARCANE_POWDER.get(), "Arcane Powder");
        add(ModItems.ANCIENT_PETAL_FRAGMENT.get(), "Ancient Petal Fragment");
        add(ModItems.MARVELOUS_ANCIENT_PETAL_FRAGMENT.get(), "Marvelous Ancient Petal Fragment");
        add(ModItems.ARCANE_PICKAXE.get(), "Arcane Pickaxe");

        add(ModBlocks.ARCANE_BLOSSOM.get(), "Arcane Blossom");
        add(ModBlocks.ANCIENT_PETAL_CLUSTER.get(), "Ancient Petal Cluster");
    }
}
