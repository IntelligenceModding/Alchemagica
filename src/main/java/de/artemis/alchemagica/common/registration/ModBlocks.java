package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.blocks.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    private static boolean always(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return true;
    }

    public static final RegistryObject<ArcaneBlossomCropBlock> ARCANE_BLOSSOM = register("arcane_blossom",
            () -> new ArcaneBlossomCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), ModItems.ARCANE_BLOSSOM_SEED::get, ModItems.ARCANE_BLOSSOM_PETAL::get));

    public static final RegistryObject<AncientPetalClusterBlock> ANCIENT_PETAL_CLUSTER = register("ancient_petal_cluster",
            () -> new AncientPetalClusterBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));

    public static final RegistryObject<ArcaneCrystalBlock> ARCANE_CRYSTAL_BLOCK = register("arcane_crystal_block",
            () -> new ArcaneCrystalBlock(BlockBehaviour.Properties.of(Material.AMETHYST).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));

    public static final RegistryObject<BuddingArcaneCrystalBlock> BUDDING_ARCANE_CRYSTAL = register("budding_arcane_crystal",
            () -> new BuddingArcaneCrystalBlock(BlockBehaviour.Properties.of(Material.AMETHYST).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));

    public static final RegistryObject<ArcaneSoilBlock> ARCANE_SOIL = register("arcane_soil",
            () -> new ArcaneSoilBlock(BlockBehaviour.Properties.of(Material.DIRT).randomTicks().strength(0.6F).sound(SoundType.GRAVEL).isViewBlocking(ModBlocks::always).isSuffocating(ModBlocks::always)));

    public static final RegistryObject<MortarAndPestleBlock> MORTAR_AND_PESTLE = register("mortar_and_pestle",
            () -> new MortarAndPestleBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.0F).sound(SoundType.STONE).noOcclusion()));

    public static final RegistryObject<ArcaneClusterBlock> ARCANE_CRYSTAL_CLUSTER = register("arcane_crystal_cluster",
            () -> new ArcaneClusterBlock(7, 3, BlockBehaviour.Properties.of(Material.AMETHYST).noOcclusion().randomTicks().strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops().lightLevel((p_152632_) -> 5)));

    public static final RegistryObject<ArcaneClusterBlock> LARGE_ARCANE_CRYSTAL_BUD = register("large_arcane_crystal_bud",
            () -> new ArcaneClusterBlock(5, 3, BlockBehaviour.Properties.copy(ARCANE_CRYSTAL_CLUSTER.get()).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((p_152632_) -> 4)));

    public static final RegistryObject<ArcaneClusterBlock> MEDIUM_ARCANE_CRYSTAL_BUD = register("medium_arcane_crystal_bud",
            () -> new ArcaneClusterBlock(4, 3, BlockBehaviour.Properties.copy(ARCANE_CRYSTAL_CLUSTER.get()).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((p_152632_) -> 2)));

    public static final RegistryObject<ArcaneClusterBlock> SMALL_ARCANE_CRYSTAL_BUD = register("small_arcane_crystal_bud",
            () -> new ArcaneClusterBlock(3, 3, BlockBehaviour.Properties.copy(ARCANE_CRYSTAL_CLUSTER.get()).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((p_152632_) -> 1)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

        return toReturn;
    }

    public static void register() {
    }

}
