package de.artemis.alchemagica.common.items;

import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModKeyBindings;
import de.artemis.alchemagica.common.registration.ModTiers;
import de.artemis.alchemagica.common.util.KeyBindingUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArcaneHoeItem extends HoeItem {

    public ArcaneHoeItem(Properties properties) {
        super(ModTiers.ARCANE, -2, 0.1F, properties);
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        Block block = useOnContext.getLevel().getBlockState(blockPos).getBlock();
        boolean success = false;

        if (block == Blocks.ROOTED_DIRT) {
            if (!useOnContext.getLevel().isClientSide) {
                Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(Items.HANGING_ROOTS));
            }
            level.setBlock(blockPos, Blocks.DIRT.defaultBlockState(), 3);
            success = true;
        } else if ((block == Blocks.GRASS_BLOCK || block == Blocks.DIRT_PATH || block == Blocks.DIRT || block == Blocks.COARSE_DIRT) &&
                useOnContext.getLevel().getBlockState(useOnContext.getClickedPos().above()).isAir()) {
            level.setBlock(blockPos, block == Blocks.COARSE_DIRT ? Blocks.DIRT.defaultBlockState() : ModBlocks.ARCANE_SOIL.get().defaultBlockState(), 3);
            success = true;
        }

        if (useOnContext.getPlayer() != null) {
            useOnContext.getItemInHand().hurtAndBreak(1, useOnContext.getPlayer(), (p_186374_) -> {
                p_186374_.broadcastBreakEvent(useOnContext.getHand());
            });
        }

        if (success) {
            level.playSound(useOnContext.getPlayer(), blockPos, SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }


    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {

        if (KeyBindingUtil.isKeyPressed(ModKeyBindings.TOGGLE_DESCRIPTION_KEYBIND)) {
            tooltip.add(Component.translatable("tooltip.alchemagica.arcane_hoe").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable(ModKeyBindings.TOGGLE_DESCRIPTION_KEYBIND.getKey().getDisplayName().getString()).withStyle(Style.EMPTY.withColor(16643423)));
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }

}
