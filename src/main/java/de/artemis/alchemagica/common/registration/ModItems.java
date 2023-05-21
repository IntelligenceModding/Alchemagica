package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.items.ArcaneShearsItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> ARCANE_BLOSSOM_SEED = Registration.ITEMS.register("arcane_blossom_seed",
            () -> new ItemNameBlockItem(ModBlocks.ARCANE_BLOSSOM.get(), (new Item.Properties()).tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ARCANE_BLOSSOM_PETAL = Registration.ITEMS.register("arcane_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ARCANE_SHARD = Registration.ITEMS.register("arcane_shard",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ARCANE_POWDER = Registration.ITEMS.register("arcane_powder",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<ArcaneShearsItem> ARCANE_SHEARS = Registration.ITEMS.register("arcane_shears",
            () -> new ArcaneShearsItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB).durability(238)));

    public static void register() {
    }

}
