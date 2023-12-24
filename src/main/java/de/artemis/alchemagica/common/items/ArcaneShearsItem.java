package de.artemis.alchemagica.common.items;

import de.artemis.alchemagica.common.registration.ModKeyBindings;
import de.artemis.alchemagica.common.registration.ModTiers;
import de.artemis.alchemagica.common.util.KeyBindingUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArcaneShearsItem extends TieredItem {

    public ArcaneShearsItem(Item.Properties properties) {
        super(ModTiers.ARCANE, properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {

        if (KeyBindingUtil.isKeyPressed(ModKeyBindings.TOGGLE_DESCRIPTION_KEYBIND)) {
            tooltip.add(Component.translatable("tooltip.alchemagica.arcane_shears").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable(ModKeyBindings.TOGGLE_DESCRIPTION_KEYBIND.getKey().getDisplayName().getString()).withStyle(Style.EMPTY.withColor(16643423)));
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }

    public boolean mineBlock(@NotNull ItemStack itemStack, Level pLevel, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull LivingEntity livingEntity) {
        if (!pLevel.isClientSide && !blockState.is(BlockTags.FIRE)) {
            itemStack.hurtAndBreak(1, livingEntity, (p_43076_) -> {
                p_43076_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return !blockState.is(BlockTags.LEAVES) && !blockState.is(Blocks.COBWEB) && !blockState.is(Blocks.GRASS) && !blockState.is(Blocks.FERN) && !blockState.is(Blocks.DEAD_BUSH) && !blockState.is(Blocks.HANGING_ROOTS) && !blockState.is(Blocks.VINE) && !blockState.is(Blocks.TRIPWIRE) && !blockState.is(BlockTags.WOOL) ? super.mineBlock(itemStack, pLevel, blockState, blockPos, livingEntity) : true;
    }

    public boolean isCorrectToolForDrops(BlockState blockState) {
        return blockState.is(Blocks.COBWEB) || blockState.is(Blocks.REDSTONE_WIRE) || blockState.is(Blocks.TRIPWIRE);
    }

    public float getDestroySpeed(@NotNull ItemStack itemStack, BlockState blockState) {
        if (!blockState.is(Blocks.COBWEB) && !blockState.is(BlockTags.LEAVES)) {
            if (blockState.is(BlockTags.WOOL)) {
                return 5.0F;
            } else {
                return !blockState.is(Blocks.VINE) && !blockState.is(Blocks.GLOW_LICHEN) ? super.getDestroySpeed(itemStack, blockState) : 2.0F;
            }
        } else {
            return 15.0F;
        }
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public net.minecraft.world.InteractionResult interactLivingEntity(@NotNull ItemStack itemStack, net.minecraft.world.entity.player.@NotNull Player playerIn, @NotNull LivingEntity livingEntity, net.minecraft.world.@NotNull InteractionHand interactionHand) {
        if (livingEntity instanceof net.minecraftforge.common.IForgeShearable target) {
            if (livingEntity.level.isClientSide) return net.minecraft.world.InteractionResult.SUCCESS;
            BlockPos pos = new BlockPos(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
            if (target.isShearable(itemStack, livingEntity.level, pos)) {
                java.util.List<ItemStack> drops = target.onSheared(playerIn, itemStack, livingEntity.level, pos,
                        net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.BLOCK_FORTUNE, itemStack));
                java.util.Random rand = new java.util.Random();
                drops.forEach(d -> {
                    net.minecraft.world.entity.item.ItemEntity ent = livingEntity.spawnAtLocation(d, 1.0F);
                    ent.setDeltaMovement(ent.getDeltaMovement().add((double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double) (rand.nextFloat() * 0.05F), (double) ((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
                });
                itemStack.hurtAndBreak(1, playerIn, e -> e.broadcastBreakEvent(interactionHand));
            }
            return net.minecraft.world.InteractionResult.SUCCESS;
        }
        return net.minecraft.world.InteractionResult.PASS;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_SHEARS_ACTIONS.contains(toolAction);
    }

    @NotNull
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof GrowingPlantHeadBlock growingplantheadblock) {
            if (!growingplantheadblock.isMaxAge(blockstate)) {
                Player player = pContext.getPlayer();
                ItemStack itemstack = pContext.getItemInHand();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
                }

                level.playSound(player, blockpos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlockAndUpdate(blockpos, growingplantheadblock.getMaxAgeState(blockstate));
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (p_186374_) -> {
                        p_186374_.broadcastBreakEvent(pContext.getHand());
                    });
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return super.useOn(pContext);
    }

}
