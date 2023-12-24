package de.artemis.alchemagica.common.blocks;

import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.util.ParticleUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class ArcaneSaplingBlock extends SaplingBlock {
    public ArcaneSaplingBlock(AbstractTreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    @NotNull
    public InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        interactionHand = InteractionHand.MAIN_HAND;
        ItemStack itemStackInHand = player.getItemInHand(interactionHand);

        // Using Arcane Powder, to speed up growth
        if (itemStackInHand.is(ModItems.ARCANE_CRYSTAL_POWDER.get())) {
            if (level.isClientSide) {
                level.playSound(player, blockPos, SoundEvents.AMETHYST_BLOCK_STEP, SoundSource.BLOCKS, 1.0F, 1.0F);
                ParticleUtil.addArcaneGrowthParticles(level, blockPos, 15, 0.02F);

                return InteractionResult.SUCCESS;
            }

            if (level.random.nextFloat() < 0.45D) {
                this.advanceTree((ServerLevel) level, blockPos, blockState, level.random);
            }

            if (!player.isCreative()) {
                itemStackInHand.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull BlockGetter level, @NotNull BlockPos blockPos, @NotNull BlockState blockState, boolean isClient) {
        return false;
    }
}