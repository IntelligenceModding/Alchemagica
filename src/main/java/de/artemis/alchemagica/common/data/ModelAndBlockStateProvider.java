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

public class ModelAndBlockStateProvider extends BlockStateProvider {

    public ModelAndBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Alchemagica.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cropBlockMaxStageThree(ModBlocks.ARCANE_BLOSSOM.get(), new ResourceLocation(Alchemagica.MOD_ID, "block/arcane_blossom_flower"), new ResourceLocation(Alchemagica.MOD_ID, "block/arcane_blossom_base"));
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
            int type = state.getValue(AGE);
            ModelFile finalModel = switch (type) {
                case 0 -> crop_stage0;
                case 1 -> crop_stage1;
                case 2 -> crop_stage2;
                default -> crop_stage3;
            };
            return ConfiguredModel.builder()
                    .modelFile(finalModel)
                    .build();
        });
    }
}
