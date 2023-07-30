package de.artemis.alchemagica.common.items;

import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.registration.ModKeyBindings;
import de.artemis.alchemagica.common.registration.ModTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class ArcaneAxeItem extends AxeItem {
    public ArcaneAxeItem(Properties properties) {
        super(ModTiers.ARCANE, 6.0F, -3.1F, properties);
    }

    @NotNull
    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        Block block = useOnContext.getLevel().getBlockState(blockPos).getBlock();
        boolean success = false;

        BlockPos blockpos = useOnContext.getClickedPos();
        Player player = useOnContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(useOnContext, net.minecraftforge.common.ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(useOnContext, net.minecraftforge.common.ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(useOnContext, net.minecraftforge.common.ToolActions.AXE_WAX_OFF, false));
        ItemStack itemstack = useOnContext.getItemInHand();
        Optional<BlockState> optional3 = Optional.empty();

        if (block == Blocks.OAK_LOG || block == Blocks.OAK_WOOD) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.OAK_BARK.get()));
            success = true;
        } else if (block == Blocks.BIRCH_LOG || block == Blocks.BIRCH_WOOD) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.BIRCH_BARK.get()));
            success = true;
        } else if (block == Blocks.SPRUCE_LOG || block == Blocks.SPRUCE_WOOD) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.SPRUCE_BARK.get()));
            success = true;
        } else if (block == Blocks.DARK_OAK_LOG || block == Blocks.DARK_OAK_WOOD) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.DARK_OAK_BARK.get()));
            success = true;
        } else if (block == Blocks.ACACIA_LOG || block == Blocks.ACACIA_WOOD) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.ACACIA_BARK.get()));
            success = true;
        } else if (block == Blocks.JUNGLE_LOG || block == Blocks.JUNGLE_WOOD) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.JUNGLE_BARK.get()));
            success = true;
        } else if (block == Blocks.MANGROVE_LOG || block == Blocks.MANGROVE_WOOD) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.MANGROVE_BARK.get()));
            success = true;
        } else if (block == Blocks.CRIMSON_STEM || block == Blocks.CRIMSON_HYPHAE) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.CRIMSON_BARK.get()));
            success = true;
        } else if (block == Blocks.WARPED_STEM || block == Blocks.WARPED_HYPHAE) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.WARPED_BARK.get()));
            success = true;
        } else if (block == ModBlocks.ARCANE_LOG.get() || block == ModBlocks.ARCANE_WOOD.get()) {
            Block.popResourceFromFace(useOnContext.getLevel(), useOnContext.getClickedPos(), useOnContext.getClickedFace(), new ItemStack(ModItems.ARCANE_BARK.get()));
            success = true;
        }

        if (optional.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            optional3 = optional;
        } else if (optional1.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3005, blockpos, 0);
            optional3 = optional1;
        } else if (optional2.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3004, blockpos, 0);
            optional3 = optional2;
        }

        if (optional3.isPresent()) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
            }

            level.setBlock(blockpos, optional3.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional3.get()));
            if (player != null) {
                itemstack.hurtAndBreak(1, player, (p_150686_) -> {
                    p_150686_.broadcastBreakEvent(useOnContext.getHand());
                });
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (success) {
            level.playSound(useOnContext.getPlayer(), blockPos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {

        if (ModKeyBindings.TOGGLE_DESCRIPTION_KEYBIND.isDown()) {
            tooltip.add(Component.translatable("tooltip.alchemagica.arcane_axe").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable(ModKeyBindings.TOGGLE_DESCRIPTION_KEYBIND.getKey().getDisplayName().getString()).withStyle(Style.EMPTY.withColor(16643423)));
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
