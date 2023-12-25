package de.artemis.alchemagica.common.containers.slots;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class ModFuelSlot extends SlotItemHandler {
    public static ItemStack validItem;

    public ModFuelSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, ItemStack validItem) {
        super(itemHandler, index, xPosition, yPosition);
        ModFuelSlot.validItem = validItem;
    }

    public boolean mayPlace(@NotNull ItemStack itemStack) {
        return mayPlaceItem(itemStack);
    }

    public static boolean mayPlaceItem(ItemStack itemStack) {
        return itemStack.is(validItem.getItem());
    }
}
