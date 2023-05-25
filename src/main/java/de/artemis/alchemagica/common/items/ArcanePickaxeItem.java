package de.artemis.alchemagica.common.items;

import de.artemis.alchemagica.common.registration.ModKeyBindings;
import de.artemis.alchemagica.common.registration.ModTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArcanePickaxeItem extends PickaxeItem {
    public ArcanePickaxeItem(Properties pProperties) {
        super(ModTiers.ARCANE, 1, -2.8F, pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {

        if (ModKeyBindings.TOGGLE_DESCRIPTION_KEYBIND.isDown()) {
            tooltip.add(Component.translatable("tooltip.alchemagica.arcanepickaxe").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable(ModKeyBindings.TOGGLE_DESCRIPTION_KEYBIND.getKey().getDisplayName().getString()).withStyle(Style.EMPTY.withColor(16643423)));
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
