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
        simpleItem(ModItems.CRUSHED_ARCANE_BLOSSOM_PETAL.get());
        simpleItem(ModItems.ARCANE_BLOSSOM_EXTRACT.get());
        simpleItem(ModItems.ARCANE_CRYSTAL_SHARD.get());
        simpleItem(ModItems.ARCANE_SHEARS.get());
        simpleItem(ModItems.ARCANE_CRYSTAL_POWDER.get());
        simpleItem(ModItems.ANCIENT_PETAL_FRAGMENT.get());
        simpleItem(ModItems.ARCANE_PICKAXE.get());
        simpleItem(ModItems.ARCANE_HOE.get());
        simpleItem(ModItems.ARCANE_AXE.get());
        simpleItem(ModItems.OAK_BARK.get());
        simpleItem(ModItems.BIRCH_BARK.get());
        simpleItem(ModItems.SPRUCE_BARK.get());
        simpleItem(ModItems.DARK_OAK_BARK.get());
        simpleItem(ModItems.JUNGLE_BARK.get());
        simpleItem(ModItems.ACACIA_BARK.get());
        simpleItem(ModItems.MANGROVE_BARK.get());
        simpleItem(ModItems.CRIMSON_BARK.get());
        simpleItem(ModItems.WARPED_BARK.get());
        simpleItem(ModItems.ARCANE_BARK.get());
        simpleItem(ModItems.ARCANE_STICK.get());

        itemWithParticle(ModItems.MARVELOUS_ANCIENT_PETAL_FRAGMENT.get());

        simpleBlockItem(ModBlocks.ARCANE_CRYSTAL_CLUSTER.get());

        advancedBlock(ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get(), Alchemagica.MOD_ID + ":generation/arcane_crystal_bud");
        advancedBlock(ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get(), Alchemagica.MOD_ID + ":generation/arcane_crystal_bud");
        advancedBlock(ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get(), Alchemagica.MOD_ID + ":generation/arcane_crystal_bud");

        simpleBlock(ModBlocks.ANCIENT_PETAL_CLUSTER.get());
        simpleBlock(ModBlocks.ARCANE_CRYSTAL_BLOCK.get());
        simpleBlock(ModBlocks.BUDDING_ARCANE_CRYSTAL.get());
        simpleBlock(ModBlocks.ARCANE_SOIL.get());
        simpleBlock(ModBlocks.MORTAR_AND_PESTLE.get());
        simpleBlock(ModBlocks.CENTRIFUGE.get());
    }

    private void simpleItem(Item item) {
        withExistingParent(DataProvider.getRegistryName(item), "item/generated").texture("layer0", new ResourceLocation(this.modid, "item/" +
                DataProvider.getRegistryNamePath(item)));
    }

    private void itemWithParticle(Item item) {
        withExistingParent(DataProvider.getRegistryName(item), this.modid + ":generation/item_with_glint_particle").texture("texture", new ResourceLocation(this.modid, "item/" +
                DataProvider.getRegistryNamePath(item)));
    }

    private void simpleBlockItem(Block block) {
        withExistingParent(DataProvider.getRegistryName(block), "item/generated").texture("layer0", new ResourceLocation(this.modid, "block/" +
                DataProvider.getRegistryNamePath(block)));
    }

    private void advancedBlock(Block block, String model) {
        withExistingParent(DataProvider.getRegistryName(block), model).texture("texture", new ResourceLocation(this.modid, "block/" +
                DataProvider.getRegistryNamePath(block)));
    }

    private void simpleBlock(Block block) {
        withExistingParent(DataProvider.getRegistryName(block), new ResourceLocation(this.modid, "block/" +
                DataProvider.getRegistryNamePath(block)));
    }
}
