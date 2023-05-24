package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Alchemagica.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ARCANE_BLOSSOM_SEED.get());
        simpleItem(ModItems.ARCANE_BLOSSOM_PETAL.get());
        simpleItem(ModItems.ARCANE_SHARD.get());
        simpleItem(ModItems.ARCANE_SHEARS.get());
        simpleItem(ModItems.ARCANE_POWDER.get());
        simpleItem(ModItems.ANCIENT_PETAL_FRAGMENT.get());
        simpleItem(ModItems.MARVELOUS_ANCIENT_PETAL_FRAGMENT.get());

        simpleBlock(ModBlocks.ANCIENT_PETAL_CLUSTER.get());
    }

    private void simpleItem(Item item) {
        withExistingParent(DataProvider.getRegistryName(item), "item/generated").texture("layer0", new ResourceLocation(this.modid, "item/" +
                DataProvider.getRegistryNamePath(item)));
    }

    private void simpleBlock(Block block) {
        withExistingParent(DataProvider.getRegistryName(block), new ResourceLocation(this.modid, "block/" +
                DataProvider.getRegistryNamePath(block)));
    }
}
