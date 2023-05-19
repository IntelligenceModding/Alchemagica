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
        add(ModItems.ARCANE_BLOSSOM_SEED.get(), "Arcane Blossom Seed");
        add(ModItems.ARCANE_BLOSSOM_PETAL.get(), "Arcane Blossom Petal");
        add(ModBlocks.ARCANE_BLOSSOM.get(), "Arcane Blossom");
    }
}
