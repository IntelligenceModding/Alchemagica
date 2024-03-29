package de.artemis.alchemagica.common.util;

import de.artemis.alchemagica.common.registration.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ParticleUtil {

    public static void addArcaneGrowthParticles(LevelAccessor level, BlockPos blockPos, int particleAmount, float particleSpeed) {
        if (particleAmount == 0) {
            particleAmount = 15;
        }

        BlockState blockstate = level.getBlockState(blockPos);
        if (!blockstate.isAir()) {
            double d0 = 0.5D;
            double d1;
            if (blockstate.is(Blocks.WATER)) {
                particleAmount *= 3;
                d1 = 1.0D;
                d0 = 3.0D;
            } else if (blockstate.isSolidRender(level, blockPos)) {
                blockPos = blockPos.above();
                particleAmount *= 3;
                d0 = 3.0D;
                d1 = 1.0D;
            } else {
                d1 = blockstate.getShape(level, blockPos).max(Direction.Axis.Y);
            }

            RandomSource randomsource = level.getRandom();
            for (int i = 0; i < particleAmount; ++i) {
                double d2 = randomsource.nextGaussian() * particleSpeed;
                double d3 = randomsource.nextGaussian() * particleSpeed;
                double d4 = randomsource.nextGaussian() * particleSpeed;
                double d5 = 0.5D - d0;
                double d6 = (double) blockPos.getX() + d5 + randomsource.nextDouble() * d0 * 2.0D;
                double d7 = (double) blockPos.getY() + randomsource.nextDouble() * d1;
                double d8 = (double) blockPos.getZ() + d5 + randomsource.nextDouble() * d0 * 2.0D;
                if (!level.getBlockState((new BlockPos(d6, d7, d8)).below()).isAir()) {
                    if (level instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ModParticles.ARCANE_GLINT_PARTICLE.get(), d6, d7, d8, 1, d2, d3, d4, d2);
                    } else {
                        level.addParticle(ModParticles.ARCANE_GLINT_PARTICLE.get(), d6, d7, d8, d2, d3, d4);
                    }
                }
            }

        }
    }
}
