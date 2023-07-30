package de.artemis.alchemagica.common.blocks;

import de.artemis.alchemagica.common.items.ArcaneAxeItem;
import de.artemis.alchemagica.common.registration.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

public class ArcaneLogBlock extends RotatedPillarBlock {
    public ArcaneLogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public BlockState getToolModifiedState(BlockState blockState, UseOnContext useOnContext, ToolAction toolAction, boolean simulate) {
        if (useOnContext.getItemInHand().getItem() instanceof ArcaneAxeItem || useOnContext.getItemInHand().getItem() instanceof AxeItem) {
            if (blockState.is(ModBlocks.ARCANE_LOG.get())) {
                return ModBlocks.STRIPPED_ARCANE_LOG.get().defaultBlockState().setValue(AXIS, blockState.getValue(AXIS));
            }
            if (blockState.is(ModBlocks.ARCANE_WOOD.get())) {
                return ModBlocks.STRIPPED_ARCANE_WOOD.get().defaultBlockState().setValue(AXIS, blockState.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(blockState, useOnContext, toolAction, false);
    }
}