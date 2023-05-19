package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.registration.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Alchemagica.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ARCANE_BLOSSOM_SEED.get());
    }

    private void simpleItem(Item item) {
        withExistingParent(DataProvider.getRegistryName(item), "item/generated").texture("layer0", new ResourceLocation(this.modid, "item/" +
                DataProvider.getRawRegistryName(item)));
    }
}
