package de.artemis.alchemagica.common.registration;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;


public class ModRarities {

    public static final Rarity ARCANE = Rarity.create("arcane", (style) -> style.withColor(ChatFormatting.LIGHT_PURPLE).withBold(true));
}
