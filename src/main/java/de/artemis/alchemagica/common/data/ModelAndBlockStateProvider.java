package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.registration.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import static de.artemis.alchemagica.common.blocks.ArcaneBlossomCropBlock.AGE;
import static de.artemis.alchemagica.common.blocks.ArcaneSoilBlock.MOISTURE;

public class ModelAndBlockStateProvider extends BlockStateProvider {

    public ModelAndBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Alchemagica.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cropBlockMaxStageThree(ModBlocks.ARCANE_BLOSSOM.get(), new ResourceLocation(Alchemagica.MOD_ID, "block/arcane_blossom_flower"), new ResourceLocation(Alchemagica.MOD_ID, "block/arcane_blossom_base"));
        simpleBlock(ModBlocks.ANCIENT_PETAL_CLUSTER.get());
        simpleBlock(ModBlocks.ARCANE_CRYSTAL_BLOCK.get());
        simpleBlock(ModBlocks.BUDDING_ARCANE_CRYSTAL.get());
        clusterBlock(ModBlocks.ARCANE_CRYSTAL_CLUSTER.get(), new ResourceLocation(Alchemagica.MOD_ID, "block/arcane_crystal_cluster"));
        clusterBlock(ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get(), new ResourceLocation(Alchemagica.MOD_ID, "block/large_arcane_crystal_bud"));
        clusterBlock(ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get(), new ResourceLocation(Alchemagica.MOD_ID, "block/medium_arcane_crystal_bud"));
        clusterBlock(ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get(), new ResourceLocation(Alchemagica.MOD_ID, "block/small_arcane_crystal_bud"));
        farmBlock(ModBlocks.ARCANE_SOIL.get(), new ResourceLocation(Alchemagica.MOD_ID, "block/arcane_soil"), new ResourceLocation(Alchemagica.MOD_ID, "block/arcane_soil_moist"), new ResourceLocation("block/dirt"));

    }

    public void farmBlock(Block block, ResourceLocation texture_top, ResourceLocation texture_top_moist, ResourceLocation texture_side) {
        ModelFile block_model = models().withExistingParent(DataProvider.getRegistryName(block.asItem()),
                new ResourceLocation("block/template_farmland")).texture("dirt", texture_side).texture("top", texture_top);
        ModelFile block_model_moist = models().withExistingParent(DataProvider.getRegistryName(block.asItem()) + "_moist",
                new ResourceLocation("block/template_farmland")).texture("dirt", texture_side).texture("top", texture_top_moist);

        farmBlock(block, block_model, block_model_moist);
    }

    public void farmBlock(Block block, ModelFile block_model, ModelFile block_model_moist) {
        getVariantBuilder(block).forAllStates(state -> {
            ModelFile finalModel = state.getValue(MOISTURE) == 7 ? block_model_moist : block_model;

            return ConfiguredModel.builder().modelFile(finalModel).build();
        });
    }

    public void cropBlockMaxStageThree(Block block, ResourceLocation texture_flower, ResourceLocation texture_base) {
        ModelFile crop_stage0 = models().withExistingParent(DataProvider.getRegistryName(block.asItem()) + "_stage0",
                new ResourceLocation(Alchemagica.MOD_ID, "generation/arcane_blossom_stage0")).renderType("cutout").texture("base", texture_base + "_stage0");
        ModelFile crop_stage1 = models().withExistingParent(DataProvider.getRegistryName(block.asItem()) + "_stage1",
                new ResourceLocation(Alchemagica.MOD_ID, "generation/arcane_blossom_stage1")).renderType("cutout").texture("base", texture_base + "_stage1");
        ModelFile crop_stage2 = models().withExistingParent(DataProvider.getRegistryName(block.asItem()) + "_stage2",
                new ResourceLocation(Alchemagica.MOD_ID, "generation/arcane_blossom_stage2")).renderType("cutout").texture("flower", texture_flower + "_stage2").texture("base", texture_base + "_stage2");
        ModelFile crop_stage3 = models().withExistingParent(DataProvider.getRegistryName(block.asItem()) + "_stage3",
                new ResourceLocation(Alchemagica.MOD_ID, "generation/arcane_blossom_stage3")).renderType("cutout").texture("flower", texture_flower + "_stage3").texture("base", texture_base + "_stage3");

        cropBlockMaxStageThree(block, crop_stage0, crop_stage1, crop_stage2, crop_stage3);
    }

    public void cropBlockMaxStageThree(Block block, ModelFile crop_stage0, ModelFile crop_stage1, ModelFile crop_stage2, ModelFile crop_stage3) {
        getVariantBuilder(block).forAllStates(state -> {
            int age = state.getValue(AGE);
            ModelFile finalModel = switch (age) {
                case 0 -> crop_stage0;
                case 1 -> crop_stage1;
                case 2 -> crop_stage2;
                default -> crop_stage3;
            };
            return ConfiguredModel.builder().modelFile(finalModel).build();
        });
    }

    public void clusterBlock(Block block, ResourceLocation texture) {
        ModelFile block_model = models().withExistingParent(DataProvider.getRegistryName(block.asItem()),
                new ResourceLocation("minecraft:block/cross")).renderType("cutout").texture("cross", texture);

        directionalBlock(block, block_model);
    }

}
