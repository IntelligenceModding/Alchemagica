package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.blocks.ArcaneBlossomCropBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<ArcaneBlossomCropBlock> ARCANE_BLOSSOM = register("arcane_blossom",
            () -> new ArcaneBlossomCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), ModItems.ARCANE_BLOSSOM_SEED::get));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

        return toReturn;
    }

    public static void register() {
    }

}
