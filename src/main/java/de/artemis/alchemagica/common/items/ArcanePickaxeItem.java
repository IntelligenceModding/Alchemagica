package de.artemis.alchemagica.common.items;

import de.artemis.alchemagica.common.registration.ModTiers;
import net.minecraft.world.item.PickaxeItem;

public class ArcanePickaxeItem extends PickaxeItem {
    public ArcanePickaxeItem(Properties pProperties) {
        super(ModTiers.ARCANE, 1, -2.8F, pProperties);
    }
}
