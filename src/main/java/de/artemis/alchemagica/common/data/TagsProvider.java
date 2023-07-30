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
import net.minecraftforge.common.Tags;
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
            tag(BlockTags.PLANKS).add(ModBlocks.ARCANE_PLANKS.get());
            tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.ARCANE_BUTTON.get());
            tag(BlockTags.WOODEN_DOORS).add(ModBlocks.ARCANE_DOOR.get());
            tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.ARCANE_STAIRS.get());
            tag(BlockTags.WOODEN_SLABS).add(ModBlocks.ARCANE_SLAB.get());
            tag(BlockTags.WOODEN_FENCES).add(ModBlocks.ARCANE_FENCE.get());
            tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.ARCANE_PRESSURE_PLATE.get());
            tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.ARCANE_TRAPDOOR.get());
            tag(BlockTags.SAPLINGS).add(ModBlocks.ARCANE_SAPLING.get());
            tag(BlockTags.LOGS_THAT_BURN).add(ModBlocks.ARCANE_LOG.get()).add(ModBlocks.STRIPPED_ARCANE_LOG.get()).add(ModBlocks.ARCANE_WOOD.get()).add(ModBlocks.STRIPPED_ARCANE_WOOD.get());
            tag(BlockTags.LEAVES).add(ModBlocks.ARCANE_LEAVES.get());
            tag(BlockTags.STANDING_SIGNS).add(ModBlocks.ARCANE_SIGN.get());
            tag(BlockTags.WALL_SIGNS).add(ModBlocks.ARCANE_WALL_SIGN.get());

            tag(ModTags.Block.ARCANE_CROPS_GROW_ON).add(ModBlocks.ARCANE_SOIL.get()).add(Blocks.FARMLAND);

            tag(Tags.Blocks.FENCE_GATES_WOODEN).add(ModBlocks.ARCANE_FENCE_GATE.get());
            tag(Tags.Blocks.FENCES_WOODEN).add(ModBlocks.ARCANE_FENCE.get());

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
