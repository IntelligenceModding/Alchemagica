package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.blocks.*;
import de.artemis.alchemagica.common.world.feature.tree.ArcaneTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class ModBlocks {

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
            () -> new MortarAndPestleBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.0F).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<CentrifugeBlock> CENTRIFUGE = register("centrifuge",
            () -> new CentrifugeBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.0F).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<ArcaneClusterBlock> ARCANE_CRYSTAL_CLUSTER = register("arcane_crystal_cluster",
            () -> new ArcaneClusterBlock(7, 3, BlockBehaviour.Properties.of(Material.AMETHYST).noOcclusion().randomTicks().strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops().lightLevel((p_152632_) -> 5)));

    public static final RegistryObject<ArcaneClusterBlock> LARGE_ARCANE_CRYSTAL_BUD = register("large_arcane_crystal_bud",
            () -> new ArcaneClusterBlock(5, 3, BlockBehaviour.Properties.copy(ARCANE_CRYSTAL_CLUSTER.get()).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((p_152632_) -> 4)));

    public static final RegistryObject<ArcaneClusterBlock> MEDIUM_ARCANE_CRYSTAL_BUD = register("medium_arcane_crystal_bud",
            () -> new ArcaneClusterBlock(4, 3, BlockBehaviour.Properties.copy(ARCANE_CRYSTAL_CLUSTER.get()).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((p_152632_) -> 2)));

    public static final RegistryObject<ArcaneClusterBlock> SMALL_ARCANE_CRYSTAL_BUD = register("small_arcane_crystal_bud",
            () -> new ArcaneClusterBlock(3, 3, BlockBehaviour.Properties.copy(ARCANE_CRYSTAL_CLUSTER.get()).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((p_152632_) -> 1)));

    public static final RegistryObject<Block> ARCANE_PLANKS = register("arcane_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<SaplingBlock> ARCANE_SAPLING = register("arcane_sapling",
            () -> new SaplingBlock(new ArcaneTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<RotatedPillarBlock> ARCANE_LOG = register("arcane_log",
            () -> arcaneLogBlock(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ARCANE_LOG = register("stripped_arcane_log",
            () -> arcaneLogBlock(MaterialColor.PODZOL, MaterialColor.PODZOL));

    public static final RegistryObject<ArcaneLogBlock> ARCANE_WOOD = register("arcane_wood",
            () -> new ArcaneLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<ArcaneLogBlock> STRIPPED_ARCANE_WOOD = register("stripped_arcane_wood",
            () -> new ArcaneLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<LeavesBlock> ARCANE_LEAVES = register("arcane_leaves",
            () -> leaves(SoundType.GRASS));

    public static final RegistryObject<ModStandingSignBlock> ARCANE_SIGN = registerWithoutBlockItem("arcane_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD, ARCANE_LOG.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD), ModWoodTypes.ARCANE));

    public static final RegistryObject<ModWallSignBlock> ARCANE_WALL_SIGN = registerWithoutBlockItem("arcane_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD, ARCANE_LOG.get().defaultMaterialColor()).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(ARCANE_SIGN.get()), ModWoodTypes.ARCANE));

    public static final RegistryObject<PressurePlateBlock> ARCANE_PRESSURE_PLATE = register("arcane_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, ARCANE_PLANKS.get().defaultMaterialColor()).noCollission().strength(0.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<TrapDoorBlock> ARCANE_TRAPDOOR = register("arcane_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(ModBlocks::never)));

    public static final RegistryObject<StairBlock> ARCANE_STAIRS = register("arcane_stairs",
            () -> new StairBlock(ARCANE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ARCANE_PLANKS.get())));

    public static final RegistryObject<FlowerPotBlock> POTTED_ARCANE_SAPLING = register("potted_arcane_sapling",
            () -> new FlowerPotBlock(ARCANE_SAPLING.get(), BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<WoodButtonBlock> ARCANE_BUTTON = register("arcane_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<SlabBlock> ARCANE_SLAB = register("arcane_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<FenceGateBlock> ARCANE_FENCE_GATE = register("arcane_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, ARCANE_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<FenceBlock> ARCANE_FENCE = register("arcane_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, ARCANE_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<DoorBlock> ARCANE_DOOR = register("arcane_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, ARCANE_PLANKS.get().defaultMaterialColor()).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));


    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerWithoutBlockItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);

        return toReturn;
    }

    private static ArcaneLogBlock arcaneLogBlock(MaterialColor topColor, MaterialColor barkColor) {
        return new ArcaneLogBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
        }).strength(2.0F).sound(SoundType.WOOD));
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    private static boolean always(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return true;
    }


    private static LeavesBlock leaves(SoundType soundType) {
        return new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(soundType).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never));
    }

    private static Boolean ocelotOrParrot(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return (boolean) (entityType == EntityType.OCELOT || entityType == EntityType.PARROT);
    }

    public static void register() {
    }

}
