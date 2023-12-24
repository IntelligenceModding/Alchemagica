package de.artemis.alchemagica.common.blocks;

import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.util.ParticleUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class ArcaneClusterBlock extends AmethystClusterBlock {
    public ArcaneClusterBlock(int size, int offset, Properties properties) {
        super(size, offset, properties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockState, Level level, BlockPos blockPos, Player player, boolean willHarvest, FluidState fluid) {
        if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.ARCANE_PICKAXE.get()) && level.random.nextBoolean()) {
            ItemEntity itemEntity2 = new ItemEntity(level, blockPos.getX() + 0.5F, blockPos.getY() + 0.5F, blockPos.getZ() + 0.5F, new ItemStack(ModItems.ARCANE_CRYSTAL_SHARD.get()));
            itemEntity2.setDefaultPickUpDelay();
            level.addFreshEntity(itemEntity2);
        }

        return super.onDestroyedByPlayer(blockState, level, blockPos, player, willHarvest, fluid);
    }

    @Override
    public void onProjectileHit(@NotNull Level level, @NotNull BlockState blockState, BlockHitResult blockHitResult, @NotNull Projectile projectile) {
        ParticleUtil.addArcaneGrowthParticles(level, blockHitResult.getBlockPos(), 3, 0.1F);
        super.onProjectileHit(level, blockState, blockHitResult, projectile);
    }
}
