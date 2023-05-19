package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.Alchemagica;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Alchemagica.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
