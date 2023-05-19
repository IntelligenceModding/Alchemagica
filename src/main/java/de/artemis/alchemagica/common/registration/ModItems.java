package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.Alchemagica;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> ARCANE_BLOSSOM_SEED = Registration.ITEMS.register("arcane_blossom_seed",
            () -> new ItemNameBlockItem(ModBlocks.ARCANE_BLOSSOM.get(), (new Item.Properties()).tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ARCANE_BLOSSOM_PETAL = Registration.ITEMS.register("arcane_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static void register() {
    }

}
