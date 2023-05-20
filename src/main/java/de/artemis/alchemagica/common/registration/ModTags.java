package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.Alchemagica;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;

public class ModTags {

    public static class Block {
        public static final TagKey<net.minecraft.world.level.block.Block> NEEDS_ARCANE_TOOL = tag("needs_arcane_tool");

        private static TagKey<net.minecraft.world.level.block.Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Alchemagica.MOD_ID, name));
        }

        private static TagKey<net.minecraft.world.level.block.Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
