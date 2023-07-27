package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.registration.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class TagsProvider {
    public static class BlockTagsProvider extends net.minecraft.data.tags.TagsProvider<Block> {
        private final DataGenerator generator;

        @SuppressWarnings("deprecation")
        protected BlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator, Registry.BLOCK, Alchemagica.MOD_ID, existingFileHelper);
            this.generator = generator;
        }

        @Override
        protected void addTags() {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.ANCIENT_PETAL_CLUSTER.get()).add(ModBlocks.ARCANE_CRYSTAL_BLOCK.get(), ModBlocks.BUDDING_ARCANE_CRYSTAL.get(), ModBlocks.ARCANE_CRYSTAL_CLUSTER.get(), ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get(), ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get(), ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get());
            tag(ModTags.Block.MAY_FARM_ARCANE_CROPS_ON).add(ModBlocks.ARCANE_SOIL.get()).add(Blocks.FARMLAND);
        }

        @NotNull
        @Override
        protected Path getPath(ResourceLocation location) {
            return this.generator.getOutputFolder().resolve("data/" + location.getNamespace() + "/tags/blocks/" + location.getPath() + ".json");
        }

        @NotNull
        @Override
        public String getName() {
            return "Block tags";
        }
    }

    public static class ItemTagsProvider extends net.minecraft.data.tags.TagsProvider<Item> {
        private final DataGenerator generator;

        @SuppressWarnings("deprecation")
        protected ItemTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator, Registry.ITEM, Alchemagica.MOD_ID, existingFileHelper);
            this.generator = generator;
        }

        @Override
        protected void addTags() {
            tag(ModTags.Item.PETAL).add(ModItems.ARCANE_BLOSSOM_PETAL.get());
        }

        @NotNull
        @Override
        protected Path getPath(ResourceLocation location) {
            return this.generator.getOutputFolder().resolve("data/" + location.getNamespace() + "/tags/items/" + location.getPath() + ".json");
        }

        @NotNull
        @Override
        public String getName() {
            return "Item tags";
        }
    }
}
