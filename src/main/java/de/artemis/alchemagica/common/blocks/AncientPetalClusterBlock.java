package de.artemis.alchemagica.common.blocks;

import de.artemis.alchemagica.common.registration.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;


public class AncientPetalClusterBlock extends Block {
    public AncientPetalClusterBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockState, Level level, BlockPos blockPos, Player player, boolean willHarvest, FluidState fluid) {
        if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.ARCANE_PICKAXE.get()) && level.random.nextBoolean()) {
            ItemEntity itemEntity2 = new ItemEntity(level, blockPos.getX() + 0.5F, blockPos.getY() + 0.5F, blockPos.getZ() + 0.5F, new ItemStack(ModItems.MARVELOUS_ANCIENT_PETAL_FRAGMENT.get()));
            itemEntity2.setDefaultPickUpDelay();
            level.addFreshEntity(itemEntity2);
        }

        return super.onDestroyedByPlayer(blockState, level, blockPos, player, willHarvest, fluid);
    }
}
