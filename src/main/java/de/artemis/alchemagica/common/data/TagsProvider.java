package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.registration.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class TagsProvider {
    public static class BlockTagsProvider extends net.minecraft.data.tags.TagsProvider<Block> {
        private DataGenerator generator;

        @SuppressWarnings("deprecation")
        protected BlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator, Registry.BLOCK, Alchemagica.MOD_ID, existingFileHelper);
            this.generator = generator;
        }

        @Override
        protected void addTags() {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.ANCIENT_PETAL_CLUSTER.get());
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
        private DataGenerator generator;

        @SuppressWarnings("deprecation")
        protected ItemTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator, Registry.ITEM, Alchemagica.MOD_ID, existingFileHelper);
            this.generator = generator;
        }

        @Override
        protected void addTags() {
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
