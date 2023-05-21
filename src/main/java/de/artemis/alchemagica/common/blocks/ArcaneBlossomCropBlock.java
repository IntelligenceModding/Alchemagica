package de.artemis.alchemagica.common.blocks;

import de.artemis.alchemagica.common.registration.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ArcaneBlossomCropBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private final Supplier<ItemLike> seed;
    private final Supplier<ItemLike> petal;

    public ArcaneBlossomCropBlock(Properties properties, Supplier<ItemLike> seed, Supplier<ItemLike> petal) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
        this.seed = seed;
        this.petal = petal;
    }

    @NotNull
    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        interactionHand = InteractionHand.MAIN_HAND;
        ItemStack itemStackInHand = player.getItemInHand(interactionHand);

        // Using Arcane Powder, to speed up growth
        if (itemStackInHand.is(ModItems.ARCANE_POWDER.get()) && !blockState.getValue(AGE).equals(getMaxAge())) {
            level.setBlock(blockPos, blockState.setValue(AGE, blockState.getValue(AGE) + 1), 3);
            level.playSound(player, blockPos, SoundEvents.AMETHYST_BLOCK_STEP, SoundSource.BLOCKS, 1.0F, 1.0F);

            if (!player.isCreative() && !level.isClientSide) {
                itemStackInHand.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }

        // Using Arcane Shears to gather petals, without destroying the crop
        if (itemStackInHand.is(ModItems.ARCANE_SHEARS.get()) && blockState.getValue(AGE).equals(getMaxAge())) {
            level.setBlock(blockPos, blockState.setValue(AGE, 0), 3);
            level.playSound(player, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 1.0F);

            if (!player.isCreative() && !level.isClientSide) {
                itemStackInHand.hurt(1, RandomSource.create(), null);

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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
