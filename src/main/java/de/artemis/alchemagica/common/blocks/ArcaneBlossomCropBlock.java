package de.artemis.alchemagica.common.blocks;

import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.registration.ModTags;
import de.artemis.alchemagica.common.util.ParticleUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ArcaneBlossomCropBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private final Supplier<ItemLike> seed;
    private final Supplier<ItemLike> petal;
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 2.0D, 11.0D);

    public ArcaneBlossomCropBlock(Properties properties, Supplier<ItemLike> seed, Supplier<ItemLike> petal) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
        this.seed = seed;
        this.petal = petal;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    @NotNull
    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        return blockState.is(ModTags.Block.ARCANE_CROPS_GROW_ON);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        interactionHand = InteractionHand.MAIN_HAND;
        ItemStack itemStackInHand = player.getItemInHand(interactionHand);

        // Using Arcane Powder, to speed up growth
        if (itemStackInHand.is(ModItems.ARCANE_CRYSTAL_POWDER.get()) && !blockState.getValue(AGE).equals(getMaxAge())) {
            level.playSound(player, blockPos, SoundEvents.AMETHYST_BLOCK_STEP, SoundSource.BLOCKS, 1.0F, 1.0F);
            ParticleUtil.addArcaneGrowthParticles(level, blockPos, 1);

            if (!player.isCreative() && !level.isClientSide) {
                itemStackInHand.shrink(1);
            }

            if (level.random.nextFloat() < 0.75D && !level.isClientSide) {
                level.setBlock(blockPos, blockState.setValue(AGE, blockState.getValue(AGE) + 1), 3);
            }

            return InteractionResult.SUCCESS;
        }

        // Using Arcane Shears to gather petals, without destroying the crop
        if (itemStackInHand.is(ModItems.ARCANE_SHEARS.get()) && blockState.getValue(AGE).equals(getMaxAge())) {
            level.setBlock(blockPos, blockState.setValue(AGE, 0), 3);
            level.playSound(player, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 1.0F);

            if (!player.isCreative() && !level.isClientSide) {
                itemStackInHand.hurt(1, RandomSource.create(), null);

                if (level.getBlockState(blockPos.below()).getBlock().equals(ModBlocks.ARCANE_SOIL.get()) && Math.random() < 0.75) {
                    if (!player.getInventory().add(new ItemStack(petal.get()))) {
                        ItemEntity itemEntity = new ItemEntity(level, blockPos.getX() + 0.5F, blockPos.getY() + 0.5F, blockPos.getZ() + 0.5F, new ItemStack(petal.get()));
                        itemEntity.setDefaultPickUpDelay();
                        level.addFreshEntity(itemEntity);
                    }
                }

                if (!player.getInventory().add(new ItemStack(petal.get()))) {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX() + 0.5F, blockPos.getY() + 0.5F, blockPos.getZ() + 0.5F, new ItemStack(petal.get()));
                    itemEntity.setDefaultPickUpDelay();
                    level.addFreshEntity(itemEntity);
                }
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @NotNull
    @Override
    public ItemLike getBaseSeedId() {
        return seed.get();
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull BlockGetter level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, boolean isClient) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
