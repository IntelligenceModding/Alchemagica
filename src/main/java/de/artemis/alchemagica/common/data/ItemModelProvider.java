package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Alchemagica.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ARCANE_BLOSSOM_SEED.get());
        simpleItem(ModItems.ARCANE_BLOSSOM_PETAL.get());
        simpleItem(ModItems.ARCANE_CRYSTAL_SHARD.get());
        simpleItem(ModItems.ARCANE_SHEARS.get());
        simpleItem(ModItems.ARCANE_CRYSTAL_POWDER.get());
        simpleItem(ModItems.ANCIENT_PETAL_FRAGMENT.get());
        simpleItem(ModItems.MARVELOUS_ANCIENT_PETAL_FRAGMENT.get());
        simpleItem(ModItems.ARCANE_PICKAXE.get());

        simpleBlockItem(ModBlocks.ARCANE_CRYSTAL_CLUSTER.get());

        advancedBlockItem(ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get(), Alchemagica.MOD_ID + ":generation/arcane_crystal_bud");
        advancedBlockItem(ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get(), Alchemagica.MOD_ID + ":generation/arcane_crystal_bud");
        advancedBlockItem(ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get(), Alchemagica.MOD_ID + ":generation/arcane_crystal_bud");
        advancedBlockItem(ModBlocks.ANCIENT_PETAL_CLUSTER.get(), Alchemagica.MOD_ID + ":generation/arcane_crystal_cluster");

        simpleBlock(ModBlocks.ARCANE_CRYSTAL_BLOCK.get());
        simpleBlock(ModBlocks.BUDDING_ARCANE_CRYSTAL.get());
    }

    private void simpleItem(Item item) {
        withExistingParent(DataProvider.getRegistryName(item), "item/generated").texture("layer0", new ResourceLocation(this.modid, "item/" +
                DataProvider.getRegistryNamePath(item)));
    }

    private void simpleBlockItem(Block block) {
        withExistingParent(DataProvider.getRegistryName(block), "item/generated").texture("layer0", new ResourceLocation(this.modid, "block/" +
                DataProvider.getRegistryNamePath(block)));
    }

    private void advancedBlockItem(Block block, String model) {
        withExistingParent(DataProvider.getRegistryName(block), model).texture("texture", new ResourceLocation(this.modid, "block/" +
                DataProvider.getRegistryNamePath(block)));
    }

    private void simpleBlock(Block block) {
        withExistingParent(DataProvider.getRegistryName(block), new ResourceLocation(this.modid, "block/" +
                DataProvider.getRegistryNamePath(block)));
    }
}
